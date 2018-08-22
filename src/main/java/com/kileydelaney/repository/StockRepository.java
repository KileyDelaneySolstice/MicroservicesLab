package com.kileydelaney.repository;

import com.kileydelaney.model.Stock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    // populates date_only field
    @Transactional
    @Modifying
    @Query(value = "UPDATE stocks SET date_only = cast(date as date)", nativeQuery = true)
    void updateDateOnlyField();


    // basic queries for lab 2
    @Query(value = "SELECT MAX(price) FROM stocks WHERE date_only = :date_only AND symbol = :symbol", nativeQuery = true)
    double getMaxPriceByDateAndSymbol(@Param("date_only") String date_only, @Param("symbol") String symbol);

    @Query(value = "SELECT MIN(price) FROM stocks WHERE date_only = :date_only AND symbol = :symbol", nativeQuery = true)
    double getMinPriceByDateAndSymbol(@Param("date_only") String date_only, @Param("symbol") String symbol);

    @Query(value = "SELECT SUM(volume) FROM stocks WHERE date_only = :date_only AND symbol = :symbol", nativeQuery = true)
    int getTotalVolumeByDateAndSymbol(@Param("date_only") String date_only, @Param("symbol") String symbol);


    // additional queries for lab 2
    @Query(value = "SELECT price FROM stocks WHERE date = (SELECT MAX(date) FROM stocks WHERE date_only = :date_only) AND symbol = :symbol LIMIT 1", nativeQuery = true)
    double getClosingPriceByDateAndSymbol(@Param("date_only") String date_only, @Param("symbol") String symbol);


    // methods for calls in repo integration tests\
    public List<Stock> findBySymbol(int symbol);

    public List<Stock> findByDate(Timestamp date);

    public List<Stock> findByDateOnly(Date dateOnly);

}
