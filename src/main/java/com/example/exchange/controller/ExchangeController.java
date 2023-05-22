package com.example.exchange.controller;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangeController {
    private final ExchangeService exchangeService;

    @GetMapping("/properties")
    public ResponseEntity<PropertiesDto> getProperties() {
        return new ResponseEntity<>(exchangeService.getProperties(), HttpStatus.OK);
    }

    @GetMapping("/symbols")
    public ResponseEntity<Currencies> getAllCurrencies() {
        return new ResponseEntity<>(exchangeService.getAllCurrencies(), HttpStatus.OK);
    }

    @PostMapping(value = "/convert", params = "mail")
    public ResponseEntity<Void> convertAndSend(
            @RequestParam String mail,
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            @RequestParam double amount
    ) {
        exchangeService.convertWithMail(mail, fromCurrency, toCurrency, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/convert")
    public ResponseEntity<ExchangeResult> convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount
    ) {
        ExchangeResult result = exchangeService.convertCurrency(from, to, amount);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}