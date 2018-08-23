package com.kileydelaney.model;
/**
 * Class representing a single stock object
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.persistence.*;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    private int symbol;

    private double price;

    private int volume;

    private Timestamp date;

    @Column(name = "date_only")
    private Date dateOnly = new Date(0,0,0);


    public Stock() {}

    public Stock(int symbol, double price, int volume, Timestamp date) {

        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
        this.dateOnly = new Date(date.getTime());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
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
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Date getDateOnly() { return dateOnly; }

    public void setDateOnly(Date dateOnly) { this.dateOnly = dateOnly; }


    public String toString() {
        return "Stock [ symbol: " + getSymbolsDict().get(symbol) + ", price: $" + price + ", volume: " + volume + ", timestamp: " + date + " ]";
    }


    /**
     * Helper method to parse JSON data from URL
     */
    public static List<Stock> jsonToList(String url) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSSZ");

        mapper.setDateFormat(dateFormat);

        Stock[] stockList = mapper.readValue(new URL(url), Stock[].class);

        return Arrays.asList(stockList);
    }


    /**
     * Helper method to build and return dictionary for looking up symbol values
     */
    public static Map<Integer, String> getSymbolsDict() {
        HashMap<Integer, String> symbolsDict = new HashMap<>();
        symbolsDict.put(1, "AAPL");
        symbolsDict.put(2, "GOOG");
        symbolsDict.put(3, "MSFT");
        symbolsDict.put(4, "PVTL");
        symbolsDict.put(5, "AMZN");

        return symbolsDict;
    }

}
