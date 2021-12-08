package com.christiandemesa.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christiandemesa.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

	// This method retrieves all the books from the database.
	List<Language> findAll();
		
}