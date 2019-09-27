package com.demo.user.controller;

import com.demo.user.model.Customer;
import com.demo.user.service.CustomerService;
import com.demo.user.api.dto.CustomerDTO;
import com.demo.user.api.service.ICustomerFeignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ICustomerFeignServiceImpl implements ICustomerFeignService {

  @Autowired
  private CustomerService customerService;

  @Override
  public CustomerDTO getCustomerById(@PathVariable(value = "id") String id) {
    ModelMapper modelMapper = new ModelMapper();
    Customer customer = this.customerService.findCustomerById(id);
    return modelMapper.map(customer,CustomerDTO.class);
  }
}
