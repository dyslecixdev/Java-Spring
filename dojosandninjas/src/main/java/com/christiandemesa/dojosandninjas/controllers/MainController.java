package com.christiandemesa.dojosandninjas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christiandemesa.dojosandninjas.models.Dojo;
import com.christiandemesa.dojosandninjas.models.Ninja;
import com.christiandemesa.dojosandninjas.services.MainService;

@Controller
public class MainController {

	@Autowired
	MainService mainServ;
	
	// Redirects to "/dojos/new" since there is no index page.
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	
	// Routes to the create dojo page.
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	// Creates a new dojo.
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}
		// There is no index page, so it redirects to the create ninja page.
		else {
			mainServ.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	// Routes to the create ninja page, and gets all the dojos for drop-down menu.
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = mainServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	// Creates a new ninja
	@PostMapping("/ninjas/new")
	// If the order was (Model model, BindingResult result) then you will get a whitelabel error from attempting to submit a form that does not meet at least one of the validations.
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = mainServ.allDojos();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		}
		// There is no index page, so it redirects to the show dojo page that this ninja is part of.
		else {
			mainServ.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
	
	// Routes to the show dojo page, and gets one dojo to show its information.
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = mainServ.oneDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
}