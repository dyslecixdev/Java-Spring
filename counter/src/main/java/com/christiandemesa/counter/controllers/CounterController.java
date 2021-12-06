package com.christiandemesa.counter.controllers;

// Imports HttpSession.
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	// HttpSession allows you to session data.
	public String index(HttpSession session) {
		// If "count" does not exist yet:
		if(session.getAttribute("count") == null) {
			// Give its data a value of 0.
			session.setAttribute("count", 0);
		}
		// If "count" does exist:
		else {
			// Uses getAttribute to retrieve the data in "count", casts it as an Integer because sessioned data is an Object, and stores it in the currentCount variable.
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			// Updates "count" with the incremented currentCount.
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/twice")
	public String twice(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			// Increments by 2 instead of 1.
			currentCount += 2;
			session.setAttribute("count", currentCount);
		}
		return "twice.jsp";
	}
	
	@RequestMapping("/counter") 
	public String count(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		// If currentCount is null, give its data a value of 0 to show on the counter.jsp file.
		if(currentCount == null) {
			model.addAttribute("countToShow", 0);
		}
		// If currentCount is a number, show that number in counter.jsp file.
		else {
			model.addAttribute("countToShow", currentCount);
		}
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		// Sets "count" to 0 to reset it.
		session.setAttribute("count", 0);
		// Redirects to @RequestMapping("/counter").
		return "redirect:/counter";
	}
}