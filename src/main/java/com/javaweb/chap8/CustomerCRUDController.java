package com.javaweb.chap8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerInterfaceRepo;

@RestController
public class CustomerCRUDController {
	@Autowired
	CustomerInterfaceRepo repo;
	
	
	@GetMapping("/testCRUD")
	public String showallCustomer() {
		Iterable<Customer> c = repo.findAll();
		for(Customer x:c) {
			System.out.println(x.getCustomerID() + " " + x.getCustomfullname());
		}
		return null;
	}
	
	
}
