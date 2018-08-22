package com.kileydelaney.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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

}