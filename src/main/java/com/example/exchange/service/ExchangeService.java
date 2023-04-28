package com.example.exchange.service;

import com.example.exchange.model.PropertiesDto;
import com.example.exchange.properties.ExchangeApiProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeApiProperties properties;

    public PropertiesDto getProperties() {
        return new PropertiesDto(properties.getApiKey(), properties.getBaseUrl());
    }
}
