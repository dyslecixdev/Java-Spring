package com.christiandemesa.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/books/{bookId}")
	// The data type (e.g. Long) comes from the model.
	public String showOne(Model model, @PathVariable("bookId") Long bookId) {
		// Creates a book variable using the constructor in Book.java, and calls on the method in BookService.java.
		Book book = bookService.findBook(bookId);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
}
