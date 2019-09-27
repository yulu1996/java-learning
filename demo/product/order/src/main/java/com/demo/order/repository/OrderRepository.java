package com.demo.order.repository;

import com.demo.order.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends org.springframework.data.repository.Repository<Order, String>, OrderRepositoryCustom {

  Order findById(String id);
}
