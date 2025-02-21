package com.javaweb.chap8;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaweb.chap8.model.Student;

@Controller
@RequestMapping("/dev")
public class StudentController {
	@GetMapping("/calyear")
	public String showStudent(@ModelAttribute Student stu,Model m) {
		int age = 2568-stu.getYearOfBirth();
		m.addAttribute("name",stu);
		m.addAttribute("age",age);
		m.addAttribute("stdid",stu.getStudentID());
		return "/showstd";
		
	}
}
