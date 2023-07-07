package com.example.kafkadhsecondconsumer.messaging.service.impl;

import com.example.kafkadhsecondconsumer.dto.OrderDto;
import com.example.kafkadhsecondconsumer.entity.Order;
import com.example.kafkadhsecondconsumer.enums.Status;
import com.example.kafkadhsecondconsumer.messaging.OrderService;
import com.example.kafkadhsecondconsumer.repository.OrdersRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;

    @Override
    @Transactional
    public Order save(OrderDto clientDto) {

        Order order= Order.builder()
                .productName(clientDto.getProductName())
                .code(clientDto.getCode())
                .quantity(clientDto.getQuantity())
                .price(clientDto.getPrice())
                .amount(clientDto.getQuantity()*clientDto.getPrice())
                .orderDate(LocalDateTime.now())
                .status(Status.APPROVED)
                .build();

        ordersRepository.save(order);
        log.info("Save order");

        return order;
    }
}
