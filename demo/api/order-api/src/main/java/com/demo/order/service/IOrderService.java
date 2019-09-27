package com.demo.order.service;

import com.demo.order.dto.OrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api
public interface IOrderService {

  @RequestMapping(method = RequestMethod.GET)
  @ApiOperation(value = "查询订单", notes = "查询订单")
  Page<OrderDTO> getAllOrders(@ApiParam(value = "产品名称", name = "productName") @RequestParam(value = "productName",required = false)String productName,
                              @ApiParam(value = "生产截止日期", name = "deadline")@RequestParam(value = "deadline",required = false)Long deadline,
                              @ApiParam(value = "订单状态", name = "status") @RequestParam(value = "status",required = false)String status,
                              @ApiParam(value = "页码，从1开始", name = "page", required = true) @RequestParam(value = "page")int page,
                              @ApiParam(value = "每页显示的条数", name = "size", required = true)  @RequestParam(value = "size")int size);



  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ApiOperation(value = "根据订单id查询订单", notes = "根据订单id查询订单")
  OrderDTO getOrderById(@ApiParam(value = "订单id", name = "id", required = true) @PathVariable(name = "id") String id);
}
