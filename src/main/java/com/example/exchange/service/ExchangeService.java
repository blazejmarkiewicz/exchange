package com.example.exchange.service;

import com.example.exchange.client.ExchangeApiClient;
import com.example.exchange.model.Currencies;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.properties.ExchangeApiProperties;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeApiProperties properties;
    private final ExchangeApiClient exchangeApiClient;


    public PropertiesDto getProperties() {
        return new PropertiesDto(properties.getApiKey(), properties.getBaseUrl());
    }

    public Currencies getAllCurrencies(){
        return exchangeApiClient.findAllCurrencies(properties.getApiKey());
    }
}
