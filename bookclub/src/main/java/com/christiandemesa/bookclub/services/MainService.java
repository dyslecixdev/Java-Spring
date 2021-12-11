package com.christiandemesa.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.christiandemesa.bookclub.models.Book;
import com.christiandemesa.bookclub.models.LoginUser;
import com.christiandemesa.bookclub.models.User;
import com.christiandemesa.bookclub.repositories.BookRepository;
import com.christiandemesa.bookclub.repositories.UserRepository;

@Service
public class MainService {
    
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
	private BookRepository bookRepo;
    
	// User methods
	// This method creates and registers a user.
    public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        }
        else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    // This method logs in a user.
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } 
        else {
            return user;
        }
    }
    
    // This method returns all the users.
    public List<User> allUsers() {
    	return userRepo.findAll();
    }
    
    // This method returns one user.
    public User oneUser(Long id) {
    	Optional<User> optUser = userRepo.findById(id);
    	if(optUser.isPresent()) {
    		return optUser.get();
    	}
    	else {
    		return null;
    	}
    }
    
    // Book methods
    // This method creates a book.
    public Book createBook(Book book) {
    	return bookRepo.save(book);
    }
    
    // This method returns all the books.
    public List<Book> allBooks() {
    	return bookRepo.findAll();
    }
    
    // This method returns one book.
    public Book oneBook(Long id) {
    	Optional<Book> optBook = bookRepo.findById(id);
    	if(optBook.isPresent()) {
    		return optBook.get();
    	}
    	else {
    		return null;
    	}
    }
    
    // This method updates a book.
    // WARNING this method creates a book instead of updating a book.
    public Book updateBook(Book book) {
    	return bookRepo.save(book);
    }
    
}