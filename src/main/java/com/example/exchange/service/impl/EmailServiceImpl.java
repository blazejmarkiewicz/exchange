package com.example.exchange.service.impl;

import com.example.exchange.model.ExchangeResult;
import com.example.exchange.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private static final String SUBJECT_PREFIX = "Exchange ";

    private final JavaMailSender emailSender;



    @Override
    public void sendSimpleMessage(String to, ExchangeResult exchangeResult) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(SUBJECT_PREFIX + LocalDate.now());
        message.setText(buildMailBody(exchangeResult));
        emailSender.send(message);
    }

    @Override
    public String buildMailBody(ExchangeResult exchangeResult) {
        StringBuilder bodyBuilder = new StringBuilder();
        bodyBuilder.append("Exchange Result:\n");
        bodyBuilder.append("From: ").append(exchangeResult.getQuery().getFrom()).append("\n");
        bodyBuilder.append("To: ").append(exchangeResult.getQuery().getTo()).append("\n");
        bodyBuilder.append("Amount: ").append(exchangeResult.getQuery().getAmount()).append("\n");
        bodyBuilder.append("Result: ").append(exchangeResult.getResult()).append("\n");
        bodyBuilder.append("Exchange ratio: ").append(exchangeResult.getResult()/exchangeResult.getQuery().getAmount()).append("\n");

        return bodyBuilder.toString();
    }

}
