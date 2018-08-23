package com.kileydelaney.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbol {

    @JsonProperty("symbol")
    private int id;

    private String name;

    public Symbol() {}

    public Symbol(int id) {
        Map<Integer, String> symbolDict = new HashMap<>();
        symbolDict.put(1, "AAPL");
        symbolDict.put(2, "GOOG");
        symbolDict.put(3, "MSFT");
        symbolDict.put(4, "PVTL");
        symbolDict.put(5, "AMZN");

        this.name = symbolDict.get(id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbol [ID=" + id + ", name=" + name + "]";
    }

}
