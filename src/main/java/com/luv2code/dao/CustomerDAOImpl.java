package com.luv2code.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer getCustomer(int id) {
		return this.entityManager.find(Customer.class, id);
	}
	
	public List<Customer> getCustomers() {
		return this.entityManager.createQuery("select c from Customer c order by firstName", Customer.class).getResultList();
	}

	@Override
	public void saveCustomer(Customer customer) {
		if(Integer.toString(customer.getId()).equals("")) {
			this.entityManager.persist(customer);
		} else {
			this.entityManager.merge(customer);
		}
	}

	@Override
	public void deleteCustomer(int id) {
		Query query = this.entityManager.createQuery("delete from Customer c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		Query query = null;
		
		if(searchName != null && searchName.trim().length() > 0) {
			query = this.entityManager.createQuery("select c from Customer c where lower(firstName) like :searchName"
					+ " or lower(lastName) like :searchName", Customer.class);
			query.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
		} else {
			query = this.entityManager.createQuery("select c from Customer c", Customer.class);
		}
		
		return query.getResultList();
	}

}
