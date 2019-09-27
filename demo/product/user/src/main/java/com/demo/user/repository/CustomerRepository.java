package com.demo.user.repository;

import com.demo.user.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends org.springframework.data.repository.Repository<Customer,String> {

  Customer findById(String id);
}
