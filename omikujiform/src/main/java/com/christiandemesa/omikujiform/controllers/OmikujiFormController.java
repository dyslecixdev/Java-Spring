package com.christiandemesa.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// Imports PostMapping
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// Imports RequestParam
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiFormController {

	@RequestMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	
	// Alternatively, could have put @RequestMapping(value="/send", method=Request.POST)
	@PostMapping("/send")
	public String send(
		// Creates a variable for each submitted value from the form in form.jsp.
		@RequestParam(value="number") Integer number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="thing") String thing,
		@RequestParam(value="text") String text,
		HttpSession session) {
			// Sessions the submitted value as the key, and the variable as the value.
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("thing", thing);
			session.setAttribute("text", text);
			// Always redirect a POST request.
			return "redirect:/omikuji/show";
		}
	
	@RequestMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		// Assigns each variable to the sessioned information.
		Integer currentNumber = (Integer) session.getAttribute("number");
		String currentCity = (String) session.getAttribute("city");
		String currentPerson = (String) session.getAttribute("person");
		String currentHobby = (String) session.getAttribute("hobby");
		String currentThing = (String) session.getAttribute("thing");
		String currentText = (String) session.getAttribute("text");
		// Adds each variable to the model.
		model.addAttribute("showNumber", currentNumber);
		model.addAttribute("showCity", currentCity);
		model.addAttribute("showPerson", currentPerson);
		model.addAttribute("showHobby", currentHobby);
		model.addAttribute("showThing", currentThing);
		model.addAttribute("showText", currentText);
		return "show.jsp";
	}
	
}
