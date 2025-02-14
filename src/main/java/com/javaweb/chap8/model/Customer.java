package com.javaweb.chap8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	private String customfullname;
	
	
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public String getCustomfullname() {
		return customfullname;
	}
	public void setCustomfullname(String customfullname) {
		this.customfullname = customfullname;
	}

	
	
	
}