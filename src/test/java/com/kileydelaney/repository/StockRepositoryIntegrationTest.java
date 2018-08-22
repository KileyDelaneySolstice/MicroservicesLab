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

        // find an inserted record using repository class
        Stock foundStock = stockRepository.findById(101L);

        // assertion
        assertThat(foundStock.getId(), is(equalTo(101L)));

    }

}
