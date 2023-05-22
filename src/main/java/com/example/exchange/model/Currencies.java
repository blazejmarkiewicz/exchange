package com.example.exchange.model;

import lombok.Data;

import java.util.Map;

@Data
public class Currencies {
    private Map<String, String> symbols;
}
