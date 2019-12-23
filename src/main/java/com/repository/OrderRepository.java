package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Customer;
import com.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

  Order findByOrderId(String orderId);

  Order findById(long id);
  
}