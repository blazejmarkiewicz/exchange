package com.example.exchange.service.impl;

import com.example.exchange.client.ExchangeApiClient;
import com.example.exchange.model.Currencies;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.properties.ExchangeApiProperties;
import com.example.exchange.service.EmailService;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeApiProperties properties;
    private final ExchangeApiClient exchangeApiClient;
    private final EmailService emailService;

    @Override public void convertWithMail(String mail){
        emailService.sendSimpleMessage(mail);
    }
    
    //TOODO converrt
    //TODO poczytaj o solid
    
    @Override public PropertiesDto getProperties() {
        return new PropertiesDto(properties.getApiKey(), properties.getBaseUrl());
    }

    @Override public Currencies getAllCurrencies(){
        return exchangeApiClient.findAllCurrencies(properties.getApiKey());
    }
}
