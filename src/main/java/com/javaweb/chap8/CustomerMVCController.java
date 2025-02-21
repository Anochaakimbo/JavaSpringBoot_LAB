package com.javaweb.chap8;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerInterfaceRepo;

@Controller
@RequestMapping("/cus")
public class CustomerMVCController {
	@Autowired
	CustomerInterfaceRepo repo;
	@GetMapping("/show/{cid}")
	public String showDetailById(@PathVariable("cid") Integer cusid,Model m) {
		
		Optional<Customer> x = repo.findById(cusid);
		System.out.println(x.get().getCustomerID());
		System.out.println(x.get().getCustomfullname());
		m.addAttribute("cid",x.get().getCustomerID());
		m.addAttribute("cname",x.get().getCustomfullname());
		return "/show-customer";
	}
}
