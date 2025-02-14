package com.javaweb.chap8.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Customer> showAllCustomer() {
		Query query = entityManager.createQuery("from Customer"); 
		return query.getResultList(); 
	}

	public Customer findById(Integer id) {
		return entityManager.find(Customer.class, id);
	}

	@Transactional
	public Customer save(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Transactional
	public void delete(Integer id) {
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer); 
	}
}