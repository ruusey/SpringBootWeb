package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.models.Customer;
import com.models.Item;
import com.models.Order;
import com.repository.CustomerRepository;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
//      repository.save(new Customer("Jack", "Bauer"));
//      repository.save(new Customer("Chloe", "O'Brian"));
//      repository.save(new Customer("Kim", "Bauer"));
//      repository.save(new Customer("David", "Palmer"));
//      repository.save(new Customer("Michelle", "Dessler"));
    	Order order = new Order("order-1992",false);
    	order.addItem(new Item("Rubber Duck",10));
    	order.addItem(new Item("Turtle Dove",2));
    	order.addItem(new Item("Lump of coal",5));
    	Customer ru = new Customer("Robert","Usey","ruusey@gmail.com");
    	ru.addOrder(order);
    	repository.save(ru);
    	
    	
      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByFirstName('Robert'):");
      log.info("--------------------------------------------");
     
       log.info( repository.findByFirstName("Robert").toString());
      
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}