package com.nolan.bibliotheque.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotheque/api/")
public class CustomerController {
	
	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAll();
	}
	
	@GetMapping("/customer/{cust-id}")
	public Customer getCustomerById(@PathVariable("cust-id") Long id) {
		return customerService.findById(id);
	}
	
	@PostMapping("/save-customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping("/update-customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@DeleteMapping("/delete-customer/{cust-id}")
	public void deleteCustomerById(@PathVariable("cust-id") Long id) {
		customerService.deleteById(id);
	}
	
}
