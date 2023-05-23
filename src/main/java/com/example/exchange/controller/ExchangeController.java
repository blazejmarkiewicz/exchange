package com.example.exchange.controller;

import com.example.exchange.model.Currencies;
import com.example.exchange.model.ExchangeResult;
import com.example.exchange.model.PropertiesDto;
import com.example.exchange.service.EmailService;
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
    private final EmailService emailService;

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
            @RequestParam String to,
            @RequestParam String from,
            @RequestParam double amount
    ) {
        ExchangeResult exchangeResult = exchangeService.convertCurrency(to, from, amount);
        emailService.sendSimpleMessage(mail, exchangeResult);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/convert")
    public ResponseEntity<ExchangeResult> convert(
            @RequestParam String to,
            @RequestParam String from,
            @RequestParam double amount
    ) {
        ExchangeResult result = exchangeService.convertCurrency(to, from, amount);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
