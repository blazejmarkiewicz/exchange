package com.example.exchange.controller;

import com.example.exchange.model.PropertiesDto;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/properties")
    public ResponseEntity<PropertiesDto> getProperties() {
        return new ResponseEntity<>(exchangeService.getProperties(), HttpStatus.OK);
//        return ResponseEntity.ok(exchangeService.getProperties());
    }
}
