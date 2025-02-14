package com.javaweb.chap8.model;


import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CustomerInterfaceRepo extends CrudRepository<Customer,Integer>{
	
	List<Customer> findByCustomfullname(String customfullname);
	
	
}
