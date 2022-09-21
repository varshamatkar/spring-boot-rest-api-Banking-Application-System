package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entity.Accounts;
import com.bankapp.entity.Customer;
import com.bankapp.repository.AccountsRepository;
import com.bankapp.repository.CustomerRepository;

@Service
public class AccountService {
	@Autowired
	private AccountsRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public List<Customer>getCustomerList(Customer customer) {
		return customerRepository.findAll();
	}
	
	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) {
		return accountRepository.findById(acctID).orElse(null);
	}
	
	public List<Customer>searchbyCustName(String custName) {
		return customerRepository.searchByCustName(custName);
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return accountRepository.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) {
		accountRepository.saveBalanceByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(int acctID, int destAcctID, int amount) {
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

}
