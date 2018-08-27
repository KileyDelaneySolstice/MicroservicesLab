package com.kileydelaney.repository;

import com.kileydelaney.model.Quote;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

    public List<Quote> findAllBySymbolName(String symbolName);

}
