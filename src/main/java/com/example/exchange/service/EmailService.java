package com.example.exchange.service;

import com.example.exchange.model.ExchangeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public interface EmailService {

    void sendSimpleMessage(String to, ExchangeResult exchangeResult);

    String buildMailBody(ExchangeResult exchangeResult);
}
