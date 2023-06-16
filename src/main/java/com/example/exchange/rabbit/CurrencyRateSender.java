package com.example.exchange.rabbit;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CurrencyRateSender {

    private final RabbitTemplate rabbitTemplate;

    public void sendRate(String message) {
        rabbitTemplate.convertAndSend("test_queue", message);
    }

    @PostConstruct
    private void send() {
        for (int i = 0; i < 10000; i++) {
            sendRate("Dupa");
        }
    }

}
