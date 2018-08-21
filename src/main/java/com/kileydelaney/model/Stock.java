package com.kileydelaney.model;
/**
 * Class representing a single stock object
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int volume;

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(name = "date_only")
    private Date date_only;


    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Timestamp getDate() {
        return timestamp;
    }

    public void setDate(Timestamp date) {
        this.timestamp = date;
    }


    public String toString() {
        return "Stock [ symbol: " + symbol + ", price: $" + price + ", volume: " + volume + ", timestamp: " + timestamp + " ]";
    }


    /**
     * Helper method to parse JSON data from URL
     *
     * @return
     * @throws IOException
     */
    public static List<Stock> jsonToList(String url) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Stock[] stockList = mapper.readValue(new URL(url), Stock[].class);

        return Arrays.asList(stockList);
    }

}
