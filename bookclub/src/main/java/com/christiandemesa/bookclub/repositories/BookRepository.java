package com.christiandemesa.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christiandemesa.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// This query finds all the books.
    List<Book> findAll();
	
}