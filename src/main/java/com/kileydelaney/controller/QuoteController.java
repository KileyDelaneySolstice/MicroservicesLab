package com.kileydelaney.controller;


import com.kileydelaney.model.Quote;
import com.kileydelaney.repository.QuoteRepository;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private QuoteRepository quoteRepository;
    private String dataUrl = "https://bootcamp-training-files.cfapps.io/week4/week4_stocks.json";


    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }


    // load quotes
    @GetMapping("/load")
    public String saveQuotes() throws Exception {
        List<Quote> stocksList = Quote.jsonToList(dataUrl);
        // load dateOnly here?
        quoteRepository.saveAll(stocksList);
        return "Quotes loaded successfully!";
    }

    // clear data
    @GetMapping("/clear")
    public String deleteQuotes() {
        quoteRepository.deleteAll();
        return "Quotes deleted successfully!";
    }

    // list quotes
    @GetMapping("/list")
    public Iterable<Quote> list() {
        return quoteRepository.findAll();
    }

    // filter quotes by stock symbol
    @GetMapping("/filter/{symbol}")
    public Iterable<Quote> filterBySymbol(@PathVariable String symbol) {
        return quoteRepository.findAllBySymbolName(symbol);
    }

}
