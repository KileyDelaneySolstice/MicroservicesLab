package com.kileydelaney.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.kileydelaney.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockControllerIntegrationTest {

    @Autowired
    StockController stockController;


    /*
    Tests that application can successfully load in JSON data from a URL
     */
    @Test
    public void testLoadDataFromUrl() throws Exception {

        String response = stockController.saveStocks();

        assertThat(response, is(equalTo("Stocks loaded successfully!")));

    }


    /*
    Tests that application can successfully delete all data that has been previously loaded in
     */
    @Test
    public void testClearData() {

        String response = stockController.deleteStocks();

        assertThat(response, is(equalTo("Stocks deleted successfully!")));

    }

    @Test
    public void addStock() {
        Stock aStock = new Stock();
        aStock.setId(101L);
        aStock.setSymbol(2);
        aStock.setPrice(19.99);
        aStock.setVolume(200);
        Timestamp testDate = new Timestamp(2018,8,22,2,29,56,33);
        Date testDateOnly = new Date(2018,8,22);
        aStock.setDate(testDate);
        aStock.setDateOnly(testDateOnly);

        Stock responseStock = stockController.add(aStock);

        assertThat(responseStock, is(equalTo(aStock)));

    }

}