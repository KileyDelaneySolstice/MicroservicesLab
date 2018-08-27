package com.kileydelaney.repository;

import com.kileydelaney.model.Quote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

    public List<Quote> findAllBySymbolName(String symbolName);

}
