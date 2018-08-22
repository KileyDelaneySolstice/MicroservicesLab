package com.kileydelaney.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.kileydelaney.model.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StockRepositoryIntegrationTest {

    @Autowired
    private StockRepository stockRepository;


    @Test
    public void testFindById() {

        // set up data scenario
        Stock aStock = new Stock();
        aStock.setId(101L);
        System.out.println(aStock);

        // find an inserted record using repository class
        Optional<Stock> foundObj = stockRepository.findById(101L);
        Stock foundStock;
        if (foundObj.isPresent()) {
            foundStock = foundObj.get();
        } else {
            foundStock = null;
        }

        // assertion
        assertThat(foundStock.getId(), is(equalTo(101L)));

    }

    @Test public void testFindBySymbol() {

        Stock aStock = new Stock();
        aStock.setSymbol(2);
        aStock.setId(102L);

        List<Stock> foundStocks = stockRepository.findBySymbol(2);

        for (Stock s: foundStocks) {
            assertThat(s.getSymbol(), is(equalTo(2)));
        }
    }

    @Test public void testFindByDate() {

        Stock aStock = new Stock();
        aStock.setSymbol(2);
        Timestamp testTs = new Timestamp(2018, 8, 2, 10, 17, 56, 33);
        aStock.setDate(testTs);

        List<Stock> foundStocks = stockRepository.findByDate(testTs);

        for (Stock s: foundStocks) {
            assertThat(s.getDate(), is(equalTo(testTs)));
        }

    }

    @Test public void testFindByDateOnly() {

        Stock aStock = new Stock();
        aStock.setSymbol(5);
        Date testDate = new Date(2-10, 8, 22);
        aStock.setDateOnly(testDate);

        List<Stock> foundStocks = stockRepository.findByDateOnly(testDate);

        for (Stock s: foundStocks) {
            assertThat(s.getDateOnly(), is(equalTo(testDate)));
        }
    }

}
