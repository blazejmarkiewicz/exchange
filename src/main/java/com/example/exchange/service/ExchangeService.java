package com.example.exchange.service;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;

public interface ExchangeService {
    void convertWithMail(String mail, String to, String from, double amount);

    ExchangeResult convertCurrency(String to, String from, double amount);

    PropertiesDto getProperties();

    Currencies getAllCurrencies();
}
