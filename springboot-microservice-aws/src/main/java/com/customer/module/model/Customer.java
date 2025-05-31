package com.customer.module.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Setter
@Getter
public class Customer {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer() {
	}
	// Builder pattern is used to create immutable objects

	
	// This is a static method that returns an instance of the CustomerBuilder
	public static CustomerBuilder builder() {
		return new CustomerBuilder();
	}

	public static class CustomerBuilder {
		private String firstName;
		private String lastName;

		public CustomerBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CustomerBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Customer build() {
			return new Customer(firstName, lastName);
		}
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
	}

}