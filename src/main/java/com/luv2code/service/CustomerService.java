package com.luv2code.service;

import java.util.List;

import com.luv2code.entity.Customer;

public interface CustomerService {

	public Customer getCustomer(int id);
	
	public List<Customer> listCustomers();
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> searchCustomers(String searchName);

}
