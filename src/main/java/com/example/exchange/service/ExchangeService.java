package com.example.exchange.service;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.model.Query;

public interface ExchangeService {
    ExchangeResult convert(String to, String from, double amount);

    ExchangeResult convert(Query query, String mail);

    PropertiesDto getProperties();

    Currencies getAllCurrencies();
}
