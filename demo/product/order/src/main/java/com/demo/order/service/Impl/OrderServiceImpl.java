package com.demo.order.service.Impl;

import com.demo.order.model.Order;
import com.demo.order.repository.OrderRepository;
import com.demo.order.service.OrderService;
import com.demo.user.api.dto.CustomerDTO;
import com.demo.user.api.service.ICustomerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ICustomerFeignService iCustomerFeignService;

    @Override
    public Page<Order> getOrderBySearchable(String productName, Long deadline, String status, int size, int page) {
        return this.orderRepository.getOrderBySearchable(productName, deadline, status, size, page);
    }

    @Override
    public Order getOrderById(String id) {
        Order order = this.orderRepository.findById(id);
        CustomerDTO customerDTO = this.iCustomerFeignService.getCustomerById(order.getCustomerId());
        order.setCustomerName(customerDTO.getName());
        order.setCustomerAddress(customerDTO.getAddress());
        order.setCustomerPhone(customerDTO.getPhone());
        return order;
    }
}
