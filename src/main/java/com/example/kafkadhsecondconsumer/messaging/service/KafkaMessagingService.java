package com.example.kafkadhsecondconsumer.messaging.service;

import com.example.kafkadhsecondconsumer.mapper.OrderEventToOrderDtoMapper;
import com.example.kafkadhsecondconsumer.messaging.OrderService;
import com.example.kafkadhsecondconsumer.messaging.event.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {

    private static final String topicCreateOrder = "${topic.send-order}";
    private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
    private final OrderService orderService;
    private final OrderEventToOrderDtoMapper orderDtoMapper;

    @Transactional
    @KafkaListener(topics = topicCreateOrder, groupId = kafkaConsumerGroupId, properties = {
            "spring.json.value.default.type=com.example.kafkadhsecondconsumer.messaging.event.OrderEvent"}
    )
    public OrderEvent createOrder(OrderEvent orderEvent) {
        log.info("Message consumed {}", orderEvent);
        orderService.save(orderDtoMapper.map(orderEvent));
        return orderEvent;
    }
}
