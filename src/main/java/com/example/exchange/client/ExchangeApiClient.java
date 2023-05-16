package com.example.exchange.client;

import com.example.exchange.model.Currencies;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ExchangeApiClient {

    @RequestLine("GET /symbols")
    @Headers("apikey: {apiKey}")
    Currencies findAllCurrencies(@Param("apiKey") String apiKey);

//    @RequestLine("GET")
//    List<BookResource> findAll();
//
//    @RequestLine("POST")
//    @Headers("Content-Type: application/json")
//    void create(Book book);

}
