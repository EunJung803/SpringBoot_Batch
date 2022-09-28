package com.ll.example.batch_exam.app.order.repository;

import com.ll.example.batch_exam.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}