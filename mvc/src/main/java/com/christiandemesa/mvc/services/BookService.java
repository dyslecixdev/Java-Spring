package com.christiandemesa.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.christiandemesa.mvc.models.Book;
import com.christiandemesa.mvc.repositories.BookRepository;

@Service
public class BookService {
 // Adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // Returns all the books (Read)
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // Creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // Retrieves a book by id (Read)
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 // Updates a book
 public Book updateBook(Book b) {
	 return bookRepository.save(b);
 }
 // Deletes a book
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }
}