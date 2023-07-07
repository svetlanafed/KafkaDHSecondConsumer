package com.example.kafkadhsecondconsumer.messaging.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private String productName;
    private String code;
    private int quantity;
    private double price;
}
