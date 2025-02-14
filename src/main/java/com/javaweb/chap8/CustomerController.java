package com.javaweb.chap8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerRepository;

@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/customer")
	public String showAll() {
		List<Customer>customerList = repo.showAllCustomer();
		for(Customer c:customerList) {
			System.out.println(c.getCustomerID() + " " + c.getCustomfullname());
		}
		return null;
	}
	
	@GetMapping("/insert")
	public String insertCustomer() {
		Customer cus1 = new Customer();
		cus1.setCustomfullname("TEST1");
		repo.save(cus1);
		return "Add successfully";
		
	}
	
}
