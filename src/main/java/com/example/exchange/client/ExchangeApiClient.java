package com.example.exchange.client;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ExchangeApiClient {


    @RequestLine("GET /symbols")
    @Headers("apikey: {apiKey}")
    Currencies findAllCurrencies(@Param("apiKey") String apiKey);

    @RequestLine("GET /convert?from={from}&to={to}&amount={amount}")
    @Headers("apikey: {apiKey}")
    ExchangeResult convertCurrency(
            @Param("apiKey") String apiKey,
            @Param("from") String from,
            @Param("to") String to,
            @Param("amount") double amount
    );
}
