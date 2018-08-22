package com.kileydelaney.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.kileydelaney.model.Stock;
import com.kileydelaney.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
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
        mockStock.setSymbol(2);
        mockStock.setVolume(200);

        when(stockController.add(any(Stock.class)))
                .thenReturn(mockStock);

        Stock aStock = new Stock();
        aStock.setSymbol(5);
        aStock.setPrice(20.99);

        Stock retStock = stockController.add(aStock);

        assertThat(retStock.getSymbol(), is(equalTo(5)));
        assertThat(retStock.getPrice(), is(equalTo(20.99)));

    }

}
