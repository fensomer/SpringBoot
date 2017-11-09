package com.rf.learning.jpaddbspringbootapp.orders.repository;

import com.rf.learning.jpaddbspringbootapp.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
}