package org.amazon.restwebservice;

import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Optional;

import org.amazon.restwebservice.entity.Customer;
import org.amazon.restwebservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	/**
	 * Handler to get the Customer object for the given id.
	 * @param customerId
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id){
		Optional<Customer> cust = null;
		Customer c= null;
		try{
			cust = customerService.getCustomerById(id);
			c = cust.get();
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
		
		System.out.println("Customer exist");
		return ResponseEntity.ok(c);
	}
	
	/**
	 * Handler to get list of all existing Customers
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> custList = customerService.getAllCustomer();
		return ResponseEntity.ok(custList);
	}
	
	/**
	 * Handler to create new Customer
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer savedCust = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCust);
	}
	
	/**
	 * Handler to update the customer with id
	 * 
	 * @param id
	 * @param updatedCust
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCust){
		Customer cust = customerService.updateCustomer(id, updatedCust);
		if(cust == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(cust);
	}
	
	/**
	 * Handler to delete the customer with id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
}