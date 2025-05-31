package com.customer.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.module.service.CustomerService;

@SpringBootTest
class SpringbootMicroserviceAwsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private CustomerService customerService; // Assuming you have a CustomerService class

	@BeforeEach
	void setUp() {
		// This method will be executed before each test method
		// You can use it to initialize resources or set up test data if needed
	}
	
	@AfterEach
	void tearDown() {
		// This method will be executed after each test method
		// You can use it to clean up resources or reset states if needed
	}
	
//	@mock vs @Autowired
	// The @Mock annotation is used to create a mock instance of the CustomerService class.
	// This allows you to isolate the tests from the actual implementation of the service.
	// The @Autowired annotation is used to inject the actual instance of the CustomerService class.
	// This allows you to test the actual functionality of the service.
	// The @Mock annotation is typically used in unit tests to create mock objects,
	// while the @Autowired annotation is used in integration tests to inject real dependencies.
	// You can use the mockCustomerService to define behavior for specific methods
	// and verify interactions with it in your tests.
	// Example test method to verify the functionality of getting all customers
	
	@Test
	void testGetAllCustomers() {
		int expectedValue = 5; // Example expected value
		int actualValue = customerService.getAllCustomers().size(); // Example actual value
		assertEquals(expectedValue, actualValue); 
    }
	
	

}
