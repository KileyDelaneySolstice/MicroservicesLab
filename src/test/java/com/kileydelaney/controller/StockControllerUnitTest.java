package com.kileydelaney.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.kileydelaney.model.Stock;
import com.kileydelaney.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerUnitTest{

    @InjectMocks
    private StockController stockController;
    private StockRepository mock;


    @Before
    public void setUp() {
        mock = Mockito.mock(StockRepository.class);
        stockController = new StockController(mock);
    }


    @Test
    public void testAddStock() throws Exception {
        Stock mockStock = new Stock();
        mockStock.setId(101L);
        mockStock.setSymbol(2);
        mockStock.setPrice(19.99);
        mockStock.setVolume(200);
        Timestamp testDate = new Timestamp(2018,8,22,2,29,56,33);
        Date testDateOnly = new Date(2018,8,22);
        mockStock.setDate(testDate);
        mockStock.setDateOnly(testDateOnly);


        when(stockController.add(any(Stock.class)))
                .thenReturn(mockStock);

        Stock aStock = new Stock();
        aStock.setId(102L);
        aStock.setSymbol(5);
        aStock.setPrice(20.99);
        aStock.setVolume(100);
        aStock.setDate(new Timestamp(2018,8,31,6,22,21,33));
        aStock.setDateOnly(new Date(2018,8,31));

        Stock retStock = stockController.add(aStock);

        assertThat(retStock.getId(), is(equalTo(101L)));
        assertThat(retStock.getSymbol(), is(equalTo(2)));
        assertThat(retStock.getPrice(), is(equalTo(19.99)));
        assertThat(retStock.getVolume(), is(equalTo(200)));
        assertThat(retStock.getDate(), is(equalTo(testDate)));
        assertThat(retStock.getDateOnly(), is(equalTo(testDateOnly)));

    }

}
