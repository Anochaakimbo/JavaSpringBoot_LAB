package com.javaweb.chap8;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerInterfaceRepo;
import com.javaweb.chap8.model.Forum;
import com.javaweb.chap8.model.ForumInterfaceRepository;

@Controller
public class ForumController {
	@Autowired
	ForumInterfaceRepository repo;
	
	@GetMapping("/insertForum")
	public String saveForum() {
		Date d = new Date();
		Forum f = new Forum();
		f.setDetail("OK HOW ARE WE TODAY");
		f.setAuthor("ANOCHAXX");
		f.setLove(15);
		f.setPost_date(d);
		repo.save(f);
		return "Add successfully";
	}
	
	@GetMapping("/showForum")
	public String findAllForum(Model m) {
		Iterable<Forum> c = repo.findAll();
		m.addAttribute("allForums",c);
		return "/forum-table";
	
	}
	
	@GetMapping("/updateLove")
	public String updateLove() {
		Forum f =  repo.findById(2);
		f.setLove(20000);
		repo.save(f);
		return null;
		
	}
}

