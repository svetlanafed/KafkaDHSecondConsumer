package com.example.kafkadhsecondconsumer.messaging;

import com.example.kafkadhsecondconsumer.dto.OrderDto;
import com.example.kafkadhsecondconsumer.entity.Order;

public interface OrderService {

    Order save(OrderDto clientDto);
}
