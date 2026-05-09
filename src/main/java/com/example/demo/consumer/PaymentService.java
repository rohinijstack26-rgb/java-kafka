package com.example.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "orders", groupId = "payment-group")
    public void processPayment(ConsumerRecord<String, String> record) {
    	System.out.println("Inside payment services");
   
    	String message=record.value();
    	 if (message == null) {
             System.out.println("Empty message received");
             return;
         }

         System.out.println("Received Order: " + message);

         String payment = message + ",status=PAID";

         kafkaTemplate.send("payments", payment);

         System.out.println("Payment Sent: " + payment);
         System.out.println("Partition: " + record.partition());
         System.out.println("Offset: " + record.offset());
      }
}