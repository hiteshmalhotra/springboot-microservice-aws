package com.customer.module.service;

import org.springframework.stereotype.Component;

import com.customer.module.model.Customer;
import com.customer.module.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
// This class is responsible for loading initial data into the database
	// It uses the CustomerRepository to save initial customer records
	
	    private final CustomerRepository customerRepository;


	    public DataLoader(CustomerRepository customerRepository) {
	        this.customerRepository = customerRepository;
	    }

	    @PostConstruct
	    public void init() {
	        customerRepository.save(new Customer("Gozde", "Yalcin"));
	        customerRepository.save(new Customer("Boncuk", "Yalcin"));
	        customerRepository.save(new Customer("Hitesh", "Malhotra"));
	        customerRepository.save(new Customer("Rajesh", "Nalcin"));
	        customerRepository.save(new Customer("Suresh", "Alcin"));
	    }
}
