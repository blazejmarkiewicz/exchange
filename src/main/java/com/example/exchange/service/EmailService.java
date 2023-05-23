package com.example.exchange.service;

import com.example.exchange.model.ExchangeResult;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmailService {
    private static final String SUBJECT_PREFIX = "Exchange ";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage(String to, ExchangeResult exchangeResult) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(SUBJECT_PREFIX + LocalDate.now());
        message.setText(buildMailBody(exchangeResult));
        emailSender.send(message);
    }

    private String buildMailBody(ExchangeResult exchangeResult) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Exchange Result:\n");
        bodyBuilder.append("From: ").append(exchangeResult.getQuery().getFrom()).append("\n");
        bodyBuilder.append("To: ").append(exchangeResult.getQuery().getTo()).append("\n");
        bodyBuilder.append("Amount: ").append(exchangeResult.getQuery().getAmount()).append("\n");
        bodyBuilder.append("Converted Amount: ").append(exchangeResult.getQuery().getAmount()).append("\n");
        return bodyBuilder.toString();
    }
}
