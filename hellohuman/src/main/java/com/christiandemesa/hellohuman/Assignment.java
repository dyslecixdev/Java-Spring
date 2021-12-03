package com.christiandemesa.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assignment {
	
	@RequestMapping("/")
	public String index(@RequestParam (value="name", required=false) String name, @RequestParam (value="last_name", required=false) String last_name, @RequestParam (value="times", required=false) Integer times) {
		if(times == null) {
			times = 1;
		}
		if(name == null && last_name == null) {
			String str = "Hello Human ";
			return str.repeat(times);
		}
		else if(name != null && last_name == null) {
			String str = String.format("Hello %s ", name);
			return str.repeat(times);
		}
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