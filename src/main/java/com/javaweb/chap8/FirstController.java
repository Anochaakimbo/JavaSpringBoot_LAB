package com.javaweb.chap8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FirstController {

	@GetMapping("/hi")
	public String hello(Model m) {
		
		m.addAttribute("name","P No");
		
		return "/hello";
	}
	
}