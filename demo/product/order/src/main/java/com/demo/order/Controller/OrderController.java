package com.demo.order.Controller;

import java.util.List;

import com.demo.order.dto.OrderDTO;
import com.demo.order.model.Order;
import com.demo.order.service.IOrderService;
import com.demo.order.service.OrderService;
import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController implements IOrderService {

  @Autowired
  private OrderService orderService;


  @RequestMapping(method = RequestMethod.GET)
  public Page<OrderDTO> getAllOrders(@RequestParam(value = "productName",required = false)String productName,
                                     @RequestParam(value = "deadline",required = false)Long deadline,
                                     @RequestParam(value = "status",required = false)String status,
                                     @RequestParam(value = "page")int page,
                                     @RequestParam(value = "size")int size){
    Page<Order> orderPage = this.orderService.getOrderBySearchable(productName, deadline, status, page, size);
    ModelMapper modelMapper = new ModelMapper();
    List<Order> orders = orderPage.getContent();
    List<OrderDTO> orderDTOS = Lists.newArrayList();
    if(!CollectionUtils.isEmpty(orders)) {
      orders.forEach(order -> {
        OrderDTO orderDTO = modelMapper.map(order,OrderDTO.class);
        orderDTOS.add(orderDTO);
      });
    }
    PageRequest pageRequest = PageRequest.of(page,size);
    return new PageImpl<OrderDTO>(orderDTOS,pageRequest,orderDTOS.size());

  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public OrderDTO getOrderById(@PathVariable(name = "id") String id){
    Order order = this.orderService.getOrderById(id);
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(order,OrderDTO.class);
  }
}


