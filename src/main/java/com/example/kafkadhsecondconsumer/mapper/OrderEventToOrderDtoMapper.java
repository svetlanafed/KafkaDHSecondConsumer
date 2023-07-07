package com.example.kafkadhsecondconsumer.mapper;

import com.example.kafkadhsecondconsumer.dto.OrderDto;
import com.example.kafkadhsecondconsumer.messaging.event.OrderEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderEventToOrderDtoMapper {

    public OrderDto map(OrderEvent orderEvent) {
        return OrderDto.builder()
                .productName(orderEvent.getProductName())
                .code(orderEvent.getCode())
                .quantity(orderEvent.getQuantity())
                .price(orderEvent.getPrice())
                .build();
    }
}
