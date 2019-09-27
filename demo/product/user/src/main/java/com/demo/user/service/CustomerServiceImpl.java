package com.demo.user.service;

import com.demo.user.model.Customer;
import com.demo.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService{

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Customer findCustomerById(String id) {
    return this.customerRepository.findById(id);
  }
}
