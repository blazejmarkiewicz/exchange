package com.example.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExchangeResult {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private double exchangeRate;
}