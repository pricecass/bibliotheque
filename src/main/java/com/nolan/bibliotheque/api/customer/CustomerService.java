package com.nolan.bibliotheque.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	// return the list of customers
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	// Return the a customer
	public Customer findById(Long customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	// Save a new customer and return that
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	// Update a customer
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	
	// Delete a customer with customerId as parameter
	public void deleteById(Long customerId) {
		customerRepository.deleteById(customerId);
	}

}
