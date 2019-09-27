package com.demo.order.service;

import com.demo.order.model.Order;
import org.springframework.data.domain.Page;

public interface OrderService {

  Page<Order> getOrderBySearchable(String productName, Long deadline, String status,
                                   int size, int page);

  Order getOrderById(String id);
}
