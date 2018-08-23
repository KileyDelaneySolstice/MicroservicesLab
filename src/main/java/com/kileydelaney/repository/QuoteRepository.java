package com.kileydelaney.repository;

import com.kileydelaney.model.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {



}
