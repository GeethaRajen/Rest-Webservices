package org.amazon.restwebservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Customer Object that will be persisted and retrieved from DB
 * 
 * */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	public Customer() {
		super();
	}

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
