package com.controllers;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Customer;
import com.repository.CustomerRepository;

@RestController
public class CustomerController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @Autowired
  private CustomerRepository repo;
  @RequestMapping("/customer/{id}")
  public List<Customer> greeting(@PathVariable("id") String firstName) {
	long start = System.currentTimeMillis();
	List<Customer> find = repo.findByFirstName(firstName);
	System.out.println((System.currentTimeMillis()-start)+"ms");
    return find;
  }
}