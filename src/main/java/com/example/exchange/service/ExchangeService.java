package com.example.exchange.service;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.PropertiesDto;

public interface ExchangeService {
    void convertWithMail(String mail);

    PropertiesDto getProperties();

    Currencies getAllCurrencies();
}
