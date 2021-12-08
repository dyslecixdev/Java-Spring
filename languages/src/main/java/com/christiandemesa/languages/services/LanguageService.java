package com.christiandemesa.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christiandemesa.languages.models.Language;
import com.christiandemesa.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository langRepo;
	
	// This method creates a language.
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	// This method returns all the languages.
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	// This method returns one language.
	public Language oneLanguage(Long id) {
		Optional<Language> optLang = langRepo.findById(id);
		if(optLang.isPresent()) {
			return optLang.get();
		}
		else {
			return null;
		}
	}
	
	// This method updates a language.
	public Language updateLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	// This method deletes a language.
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
	
}