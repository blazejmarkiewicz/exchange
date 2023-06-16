package com.example.exchange.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CurrencyRateListener {

    @RabbitListener(queues = "test_queue")
    public void receiveMessage(String message) {
       log.info("Received: " + message);
    }
}