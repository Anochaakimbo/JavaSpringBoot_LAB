package com.javaweb.chap8;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerInterfaceRepo;
import com.javaweb.chap8.model.Forum;
import com.javaweb.chap8.model.ForumInterfaceRepository;

@Controller
public class ForumController {
	@Autowired
	ForumInterfaceRepository repo;
	
	@GetMapping("/insertF")
	public String saveForum1() {
		Date d = new Date();
		Forum f = new Forum();
		f.setDetail("OK HOW ARE WE TODAY");
		f.setAuthor("ANOCHAXX");
		f.setLove(15);
		f.setPost_date(d);
		repo.save(f);
		return "Add successfully";
	}
	
	@GetMapping("/insertForum")
	public String saveForum(@RequestParam("detail") String detail,@RequestParam("author") String author,Model m) {
	    Date d = new Date();
	    Forum f = new Forum();
	    f.setDetail(detail);      
	    f.setAuthor(author);       
	    f.setLove(0);
	    f.setPost_date(d);
	    repo.save(f);               
	    return "redirect:/showForum";
	}

	
	@GetMapping("/showForum")
	public String findAllForum(Model m) {
		Iterable<Forum> c = repo.findAll();
		m.addAttribute("allForums",c);
		return "/forum-table";
	
	}
	
	@GetMapping("/updateForm/{id}")
	public String loadForm(@PathVariable int id,Model m) {
		Forum f =  repo.findById(id);
		System.out.println(id);
		m.addAttribute("Forum",f);
		return "/update-form";
		
	}
	
	@PostMapping("/updateForum")
	public String updateForum(@ModelAttribute Forum editForum,Model m) {
		Forum oldForum = repo.findById(editForum.getId());
		oldForum.setAuthor(editForum.getAuthor());
		oldForum.setDetail(editForum.getDetail());
		oldForum.setLove(editForum.getLove());
		repo.save(oldForum);
		return "redirect:/showForum";
		
	}
	
	@GetMapping("/deleteForum")
	public String deleteForum(@RequestParam int id,Model m) {
		Forum f =  repo.findById(id);
		repo.delete(f);
		return "redirect:/showForum";
		
	}
	@GetMapping("/loveAdd/{id}")
	public String lovePress(@PathVariable int id, Model m) {
	    Forum f = repo.findById(id); 
	    if (f != null) {
	        f.setLove(f.getLove() + 1); 
	        repo.save(f); 
	    }
	    return "redirect:/showForum";
	}

}

