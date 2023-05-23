package com.example.exchange.service.impl;

import com.example.exchange.client.ExchangeApiClient;
import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.properties.ExchangeApiProperties;
import com.example.exchange.service.EmailService;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangeApiProperties properties;
    private final ExchangeApiClient exchangeApiClient;
    private final EmailService emailService;

    @Override
    public void convertWithMail(String mail, String to, String from, double amount) {
        ExchangeResult exchangeResult = exchangeApiClient.convertCurrency(properties.getApiKey(), to, from, amount);
        emailService.sendSimpleMessage(mail, exchangeResult);
    }

    @Override
    public ExchangeResult convertCurrency(String to, String from, double amount) {
        return exchangeApiClient.convertCurrency(properties.getApiKey(), to, from, amount);
    }

    
    @Override
    public PropertiesDto getProperties() {
        return new PropertiesDto(properties.getApiKey(), properties.getBaseUrl());
    }

    @Override
    public Currencies getAllCurrencies() {
        return exchangeApiClient.findAllCurrencies(properties.getApiKey());
    }
}
