package com.customer.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.customer.module.model.Customer;
import com.customer.module.model.dto.CreateCustomerDto;
import com.customer.module.repository.CustomerRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
    /**
     * * Retrieves all customers from the repository.
     * * @throws IllegalArgumentException if the customer list is empty
     * @return
     */
	// Resilience4j annotations for retry and circuit breaker
	
	@Retry(name = "customerServiceRetry", fallbackMethod = "fallbackGetAllCustomers")
	@CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackGetAllCustomers")

	/**
	 * Retrieves all customers from the repository.
	 * 
	 * @return List of all customers
	 * @throws IllegalArgumentException if the customer list is empty
	 */
	public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

	public List<Customer> fallbackGetAllCustomers(RuntimeException e) {
		// Log the exception (optional)
		
		System.err.println("Error retrieving customers: " + e.getMessage());
		// Return an empty list or a default value
		return List.of();
	}
	
	/**
	 * Creates a new customer in the repository.
	 * 
	 * @param dto
	 * @throws IllegalArgumentException if the dto is empty
	 */
	

    public void createCustomer(CreateCustomerDto dto) {

        if (ObjectUtils.isEmpty(dto)) {
            throw new IllegalArgumentException("customer is empty");
        }
        Customer customer = Customer.builder().firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        customerRepository.save(customer);
    }
}
