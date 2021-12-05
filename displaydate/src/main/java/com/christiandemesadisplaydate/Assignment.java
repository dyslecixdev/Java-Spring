package com.christiandemesadisplaydate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

// Imports Date().
import java.util.Date;
// Imports SimpleDateFormat().
import java.text.SimpleDateFormat;

@Controller
public class Assignment {
        
        @RequestMapping("/")
    	public String home() {
    		return "index.jsp";
    	}
        
        @RequestMapping("/date")
        public String date(Model model) {
        	
        	Date currDate = new Date();
        	// Creates a variable that formats where E is each capital letter in the day, d is each number in the day, M is each capital letter in the month, and y is each number in the year.
        	SimpleDateFormat formatter = new SimpleDateFormat("EEEEEEEEE, 'the' dd 'of' MMMMMMMMM, yyyy");
        	// Formats the date with the formatter.
        	String formatDate = formatter.format(currDate);
        	
        	model.addAttribute("date", formatDate);
        	
        	return "date.jsp";
        	
        }
        
        @RequestMapping("/time")
        public String time(Model model) {
        	
        	Date currTime = new Date();
        	// Creates a variable that formats where h is each number in the 12 hour system, m is each number in the minute, and aa is AM or PM.
        	SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa");
        	String formatTime = formatter.format(currTime);
        	
        	model.addAttribute("time", formatTime);
        	
        	return "time.jsp";
        	
        }

}