package com.example.exchange.model;

import lombok.Data;

@Data
public class ExchangeResult {
    private String to;
    private String from;
    private double amount;
    private double result;
    private boolean success;


}
