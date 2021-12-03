package com.christiandemesa.daikichiroutes;

// Imports RequestMapping
import org.springframework.web.bind.annotation.RequestMapping;
// Imports RestController
import org.springframework.web.bind.annotation.RestController;

// RestController allows the controller to respond with data (e.g. Strings).
@RestController
// Wraps a RequestMapping around the methods in the class
@RequestMapping("/daikichi")
public class Assignment {
	
	// Methods
	// Will appear at localhost:8080/daikichi
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	// Will appear at localhost:8080/daikichi/today
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	// Will appear at localhost:8080/daikichi/tomorrow
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
}