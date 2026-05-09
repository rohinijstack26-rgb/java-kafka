package com.example.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String orderId, double amount) {
        String message = "orderId:" + orderId + ",amount:" + amount;

        kafkaTemplate.send("orders", orderId, message);
        System.out.println("Order Sent: " + message);
    }
	    
}
