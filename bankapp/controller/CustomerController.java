package com.bankapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bankapp.entity.Customer;
import com.bankapp.service.CustomerService;


@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		accountController.createAccount(customer.getCustomerID(), 0, "Active", customer);
		return customer;
		
	}
	
   @GetMapping("/findcustomerbyid/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return customerService.getCustomerInfo(acctID);
	}
   
	}