package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


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
