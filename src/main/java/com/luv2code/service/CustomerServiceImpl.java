package com.luv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.dao.CustomerDAO;
import com.luv2code.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
	
	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchName) {
		return customerDao.searchCustomers(searchName);
	}

}
