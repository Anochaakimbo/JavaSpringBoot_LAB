package com.javaweb.chap8;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.chap8.model.Customer;
import com.javaweb.chap8.model.CustomerInterfaceRepo;
import com.javaweb.chap8.model.Forum;
import com.javaweb.chap8.model.ForumInterfaceRepository;

@RestController
@RequestMapping("/api/v2")
public class ForumController {
	@Autowired
	ForumInterfaceRepository repo;
	
	@PostMapping("/forum")
	public Forum saveForum(@RequestBody Forum forum) {
	    return repo.save(forum);
	}

	
	@GetMapping("/forum/{id}")
	public ResponseEntity<?> getForum(@PathVariable Integer id) {
		Forum forum = repo.findById(id);
		
		if(forum !=null) {
			return new ResponseEntity<>(forum,HttpStatus.OK);
			
		}else {
			ErrorDetail errorDetail = new ErrorDetail();
			errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
			errorDetail.setMessage("Forum with id" + id +"not found");
			return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/forum")
	public Iterable<Forum> getAllForum() {
		return repo.findAll();
	}
	
	@DeleteMapping("/forum/{id}")
	public void deleteForum(@PathVariable("id") Integer id) {
		Forum forum = repo.findById(id);
		repo.delete(forum);
		
	}
	@PutMapping("/forum/{id}/love")
	public Forum editLove(@RequestBody Forum forum) {
	    Forum f = repo.findById(forum.getId()); 
	    f.setLove(forum.getLove());
	    return repo.save(f);
}
}

