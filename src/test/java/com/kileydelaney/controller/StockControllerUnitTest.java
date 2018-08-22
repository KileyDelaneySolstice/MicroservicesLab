package com.kileydelaney.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kileydelaney.model.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
public class StockControllerUnitTest{

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StockController stockController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStock() throws Exception {
        Stock mockStock = new Stock();
        mockStock.setSymbol("GOOG");
        mockStock.setVolume(200);

        when(stockController.add(any(Stock.class)))
                .thenReturn(mockStock);

        Stock aStock = new Stock();
        aStock.setSymbol("AMZN");
        aStock.setPrice(20.99);

        mockMvc.perform(post("/add", aStock))
                .andExpect(status().isOk()).andReturn();
    }

}
