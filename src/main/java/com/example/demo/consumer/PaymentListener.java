package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @KafkaListener(topics = "payments", groupId = "logger-group")
    public void listen(String message) {
        System.out.println("Payment Received: " + message);
    }
}
