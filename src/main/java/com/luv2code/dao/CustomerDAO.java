package com.luv2code.dao;

import java.util.List;

import com.luv2code.entity.Customer;

public interface CustomerDAO {
	
	public Customer getCustomer(int id);

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public List<Customer> searchCustomers(String searchName);

}
