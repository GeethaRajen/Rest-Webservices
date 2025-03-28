package org.amazon.restwebservice.service;

import java.util.List;
import java.util.Optional;

import org.amazon.restwebservice.entity.Customer;
import org.amazon.restwebservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles the business logic of Customer objects
 */
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	
	/**
	 * Get Customer object for the given id
	 * 
	 * @param id
	 * @return Customer
	 */
	public Optional<Customer> getCustomerById(int id) {
		return repository.findById(id);
	}
	
	/**
	 * Get all Customer objects from the Database 
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> getAllCustomer(){
		return repository.findAll();
	}
	
	/**
	 * Get the Customer object for the given id and update with details
	 * 
	 * @param id
	 * @param updatedCustomer Customer to be updated in Database
	 * @return
	 */
	public Customer updateCustomer(int id, Customer updatedCustomer) {
		return repository.findById(id).map(cust -> {
			cust.setEmail(updatedCustomer.getEmail());
			cust.setName(updatedCustomer.getName());
			repository.save(cust);
			return cust;
		}).orElse(null);		
	}
	
	/**
	 * Delete the Customer object corresponding to the given id
	 * 
	 * @param id
	 */
	public void deleteCustomer(int id) {
		repository.deleteById(id);
	}
	
	/**
	 * Persists the Customer object in Database.
	 * 
	 * @param customer
	 * @return Customer object after persisting
	 */
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}
}