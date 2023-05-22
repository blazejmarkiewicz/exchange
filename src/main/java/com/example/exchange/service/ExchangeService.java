package com.example.exchange.service;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;

public interface ExchangeService {
    void convertWithMail(String mail, String fromCurrency, String toCurrency, double amount);

    ExchangeResult convertCurrency(String from, String to, double amount);

    PropertiesDto getProperties();

    Currencies getAllCurrencies();
}