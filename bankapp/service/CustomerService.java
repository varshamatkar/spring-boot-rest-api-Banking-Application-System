package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankapp.entity.Customer;
import com.bankapp.repository.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	
  public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int customerID) {
		return customerRepository.findById(customerID).orElse(null);
	}

	public void deleteCustomer(int customerID) {
		customerRepository.deleteById(customerID);
	}
	
	
}