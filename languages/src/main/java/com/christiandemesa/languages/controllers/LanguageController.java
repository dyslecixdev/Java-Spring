package com.christiandemesa.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christiandemesa.languages.models.Language;
import com.christiandemesa.languages.services.LanguageService;

@Controller
public class LanguageController {

	@Autowired
	LanguageService langServ;
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langServ.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			List<Language> languages = langServ.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		else {
			langServ.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = langServ.oneLanguage(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		}
		else {
			langServ.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Language language = langServ.oneLanguage(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		langServ.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
