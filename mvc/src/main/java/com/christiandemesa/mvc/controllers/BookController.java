package com.christiandemesa.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christiandemesa.mvc.models.Book;
import com.christiandemesa.mvc.services.BookService;

@Controller
public class BookController {

	/*
	@Autowired is used to replace the following:
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
	*/
	@Autowired
	BookService bookService;
	
	// Route that shows all the books.
	@RequestMapping("/books")
	public String showAll(Model model) {
		// Creates a books list calling on the method in BookService.java
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";   
	}
	
	// Route that shows one book by its id.
	@GetMapping("/books/{bookId}")
	// The data type (e.g. Long) comes from the model.
	public String showOne(Model model, @PathVariable("bookId") Long bookId) {
		// Creates a book variable using the constructor in Book.java, and calls on the method in BookService.java.
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
}
