package com.kileydelaney.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.persistence.*;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "stocks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @JsonProperty("symbol")
    private int symbol;

    private String symbolName;

    @JsonProperty("volume")
    private int volume;

    @JsonProperty("price")
    private double price;

    @JsonProperty("date")
    private Timestamp date;


    public Quote() {}

    public Quote(int symbolId, int volume, double price, Timestamp date) {
        this.symbol = symbolId;
        this.volume = volume;
        this.price = price;
        this.date = date;
        this.symbolName = getSymbolName();
    }


    public Long getId() {
        return id;
    }

    public int getSymbolId() {
        return symbol;
    }

    public String getSymbolName() {
        Symbol symbol = new Symbol(this.symbol);
        return symbol.getName();
    }

    public int getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getDate() {
        return date;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSymbolId(int symbolId) {
        this.symbol = symbolId;
    }

    public void setSymbolName(String name) {
        this.symbolName = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Stock [symbol=" + symbolName + ", volume=" + volume + ", price=$" + price + ", date=" + date.toString() + "]";
    }


    /**
     * Helper method to parse JSON data from URL
     */
    public static List<Quote> jsonToList(String url) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSSZ");

        mapper.setDateFormat(dateFormat);

        Quote[] quoteList = mapper.readValue(new URL(url), Quote[].class);

        for (Quote q : quoteList) {
            q.setSymbolName(q.getSymbolName());
        }

        return Arrays.asList(quoteList);
    }

    public static void main(String[] args) throws Exception {
        System.out.print(jsonToList("https://bootcamp-training-files.cfapps.io/week4/week4_stocks.json"));
    }

}
