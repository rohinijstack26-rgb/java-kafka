package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.producer.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }
    @PostMapping
    public String createOrder(@RequestParam String orderId,
                              @RequestParam double amount) {

        producer.sendOrder(orderId, amount);
        return "Order Created: " + orderId + ", amount: " + amount;
    }
    
  /*  @PostMapping
    public String createOrder() {
    	System.out.println("Inside createOrder in Ordercontroller");
        producer.sendOrder("101", 500);
        return "Order Created";
    }*/
    
  
}
