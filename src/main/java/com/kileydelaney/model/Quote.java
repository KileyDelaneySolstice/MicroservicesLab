package com.kileydelaney.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

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




}
