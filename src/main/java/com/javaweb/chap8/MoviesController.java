package com.javaweb.chap8;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaweb.chap8.model.Movies;

@Controller
public class MoviesController {
	@GetMapping("/movies")
	public String ShowAll(Model model) {
		ArrayList<Movies> mlist = new ArrayList<Movies>();
		
		Movies m1 = new Movies();
		
		m1.setMovieID(1);
		m1.setMovieType("fantasy");
		m1.setMovieName("Montra");
		
		Movies m2 = new Movies();
		
		m2.setMovieID(2);
		m2.setMovieType("horror");
		m2.setMovieName("Teeyod2");
		
		
		mlist.add(m1);
		mlist.add(m2);
		
		model.addAttribute("allMovies",mlist);
		
		return "/show-movies";
	}
}
