package com.kileydelaney;

import com.kileydelaney.model.Stock;
import com.kileydelaney.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@SpringBootApplication
public class MicroservicesLabApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroservicesLabApplication.class, args);

    }

    @Bean
    CommandLineRunner addStocks(StockRepository repo) {
        return args -> {
            Calendar cal = Calendar.getInstance();
            Date now = cal.getTime();
            Timestamp currDate = new Timestamp(now.getTime());
            List<Stock> stocks = asList(
                    new Stock(1, 562.49, 1501, currDate),
                    new Stock(2, 472.76, 1694, currDate),
                    new Stock(3, 600.92, 1341, currDate)
            );

            repo.saveAll(stocks);
        };
    }

}
