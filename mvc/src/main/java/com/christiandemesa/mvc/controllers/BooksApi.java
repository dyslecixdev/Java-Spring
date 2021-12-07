package com.christiandemesa.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.christiandemesa.mvc.models.Book;
import com.christiandemesa.mvc.services.BookService;

@RestController
public class BooksApi {
    // Tells us we are using bookService, and we will not change it.
    private final BookService bookService;
    // Injects it to be available in the controller.
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    // This method returns all the books (Read).
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    // This method creates a book.
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(
    	@RequestParam(value="title") String title, 
    	@RequestParam(value="description") String desc, 
    	@RequestParam(value="language") String lang, 
    	@RequestParam(value="pages") Integer numOfPages) {
        	Book book = new Book(title, desc, lang, numOfPages);
        	return bookService.createBook(book);
    }
    // This method returns a book by its id (Read).
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    // This method updates a book.
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(
    	@PathVariable("id") Long id,
    	@RequestParam(value="title") String title,
    	@RequestParam(value="description") String desc, 
    	@RequestParam(value="language") String lang, 
    	@RequestParam(value="pages") Integer numOfPages) {
    		Book book = new Book(title, desc, lang, numOfPages);
    		// Sets the id of the new Book.
    		book.setId(id);
    		book = bookService.updateBook(book);
    		return book;
    }
    // This method deletes a book.
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }
    
}