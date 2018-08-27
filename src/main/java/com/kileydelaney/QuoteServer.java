package com.kileydelaney;

import com.kileydelaney.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class QuoteServer {

	@Autowired
	protected StockRepository stockRepository;

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "quote-server");

		SpringApplication.run(QuoteServer.class, args);
	}
}
