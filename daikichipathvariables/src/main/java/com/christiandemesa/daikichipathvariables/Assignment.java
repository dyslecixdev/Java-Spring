package com.christiandemesa.daikichipathvariables;

// Import @PathVariable.
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class Assignment {
	
	@RequestMapping("/travel/{location}")
	// Notice how the location in @PathVariable matches the location in @RequestMapping.
	public String showLocation(@PathVariable("location") String location) {
		return String.format("Congratulations! You will soon travel to %s!", location);
	}
	
	@RequestMapping("/lotto/{number}")
	public String showLocation(@PathVariable("number") Integer number) {
		// Runs if the number when divided by 2 will have a remainder of 1 (i.e. an odd number).
		if(number % 2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		// Runs if the number is even.
		else {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
	}

}
