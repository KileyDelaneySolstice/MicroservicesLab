package com.kileydelaney.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.org.apache.xpath.internal.operations.Quo;
import sun.java2d.pipe.SpanShapeRenderer;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import static java.util.Arrays.asList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty("symbol")
    private int symbolId;

    @JsonProperty("volume")
    private int volume;

    @JsonProperty("price")
    private double price;

    @JsonProperty("date")
    private Timestamp date;


    public void Quote() {}

    public void Quote(int symbolId, int volume, double price, Timestamp date) {
        this.symbolId = symbolId;
        this.volume = volume;
        this.price = price;
        this.date = date;
    }


    public String getSymbolName() {
        Symbol symbol = new Symbol(this.symbolId);
        return symbol.getName();
    }

    public int getSymbolId() {
        return symbolId;
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

    @Override
    public String toString() {
        return "Stock [symbol=" + getSymbolName() + ", volume=" + volume + ", price=$" + price + ", date=" + date.toString();
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

        return Arrays.asList(quoteList);
    }

}
