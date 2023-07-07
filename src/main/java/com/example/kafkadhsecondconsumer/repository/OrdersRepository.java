package com.example.kafkadhsecondconsumer.repository;


import com.example.kafkadhsecondconsumer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
}
