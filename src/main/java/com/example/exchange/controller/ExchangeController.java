package com.example.exchange.controller;

import com.example.exchange.model.Currencies;
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

    private final ExchangeService exchangeServiceImpl;

    @GetMapping("/properties")
    public ResponseEntity<PropertiesDto> getProperties() {
        return new ResponseEntity<>(exchangeServiceImpl.getProperties(), HttpStatus.OK);
//        return ResponseEntity.ok(exchangeService.getProperties());
    }

    @GetMapping("/symbols")
    public ResponseEntity<Currencies> getAllCurrencies(){
        return new ResponseEntity<>(exchangeServiceImpl.getAllCurrencies(), HttpStatus.OK);
    }

    @PostMapping(value = "/convert", params = "mail")
    public ResponseEntity<Void> convertAndSend(@RequestParam String mail){
        exchangeServiceImpl.convertWithMail(mail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
