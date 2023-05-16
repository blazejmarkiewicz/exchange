package com.example.exchange.configuration;

import com.example.exchange.client.ExchangeApiClient;
import com.example.exchange.properties.ExchangeApiProperties;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeApiClientConfig {

    @Bean
    public ExchangeApiClient exchangeApiClient(ExchangeApiProperties properties) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ExchangeApiClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ExchangeApiClient.class, properties.getBaseUrl());
    }
}
