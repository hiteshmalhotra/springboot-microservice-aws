package com.customer.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.module.model.Customer;
import com.customer.module.model.dto.CreateCustomerDto;
import com.customer.module.service.CustomerService;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
	
	private final CustomerService customerService;

	@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @PostMapping("create")
    public ResponseEntity<CreateCustomerDto> createCustomer(CreateCustomerDto dto) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok(dto);
    }
    
    // Health check endpoints
    @GetMapping("/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("Service is up and running");
	}
    
}
