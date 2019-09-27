package com.demo.order.repository;

import com.demo.order.model.Order;
import org.springframework.data.domain.Page;

public interface OrderRepositoryCustom {

  Page<Order> getOrderBySearchable(String productName, Long deadline, String status, int size, int page);


}
