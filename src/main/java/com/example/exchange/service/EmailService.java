package com.example.exchange.service;

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

    //    public void sendSimpleMessage(String to, ExchangeResult exchangeResult) {  //todo: do odkomentowania po implementacji usługi convert
    public void sendSimpleMessage(String to) {   //todo: do usunięcia po implementacji usługi convert
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(SUBJECT_PREFIX + LocalDate.now());
//        message.setText(buildMailBody(exchangeResult)); //todo: do odkomentowania po implementacji buildMailBody()
        message.setText("test body");  //todo: do usunięcia po implementacji buildMailBody()
        emailSender.send(message);
    }

//    private String buildMailBody(ExchangeResult exchangeResult) {
        // TODO: 19.05.2023 budowa ładnie sformatowanego Stringa, który będzie wykorzystywany jako treść maila
//    }
}

