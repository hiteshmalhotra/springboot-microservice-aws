package com.customer.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.module.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
