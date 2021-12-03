package com.christiandemesa.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assignment {
	
	@RequestMapping("/")
	// Had times as Integer instead of int so if times was not included, it would have a value of null.
	public String index(@RequestParam (value="name", required=false) String name, @RequestParam (value="last_name", required=false) String last_name, @RequestParam (value="times", required=false) Integer times) {
		// Remove edge case of times being null.
		if(times == null) {
			times = 1;
		}
		// Remove edge case of no name and last_name inputs.
		if(name == null && last_name == null) {
			String str = "Hello Human ";
            		// .repeat() repeats the string for whatever number times is.
			return str.repeat(times);
		}
      		// Remove edge case of no last_name input.
		else if(name != null && last_name == null) {
			String str = String.format("Hello %s ", name);
			return str.repeat(times);
		}
        	// Remove edge case of no name input
		else if(name == null && last_name != null) {
			String str = String.format("Hello %s ", last_name);
			return str.repeat(times);
		}
		else {
			String str = String.format("Hello %s %s ", name, last_name);
			return str.repeat(times);
		}
	}

}
