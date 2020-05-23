package com.example.bbb;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao  extends JpaRepository<OrderItem,Long> {
}
