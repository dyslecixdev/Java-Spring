package com.christiandemesa.bookclub.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christiandemesa.bookclub.models.Book;
import com.christiandemesa.bookclub.models.LoginUser;
import com.christiandemesa.bookclub.models.User;
import com.christiandemesa.bookclub.services.MainService;

@Controller
public class MainController {
    
	@Autowired
    private MainService mainServ;
    
	// Routes to the login and registration page.
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    // Registers a user, and redirects to the dashboard page.
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        mainServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // Sessions the user_id and user_name for use in the jsp files.
        session.setAttribute("user_id", newUser.getId());
        session.setAttribute("user_name", newUser.getUserName());
        return "redirect:/dashboard";
    }
    
    // Logs in a user, and redirects to the dashboard page.
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
    	User user = mainServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_name", user.getUserName());
        return "redirect:/dashboard";
    }
    
    // Routes to the dashboard page.
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("user_id") != null) {
    		List<Book> books = mainServ.allBooks();
    		model.addAttribute("books", books);
    		return "/bookclubs/dashboard.jsp";
    	}
    	// If a user did not register or login, it redirects to the login and registration page.
    	else {
    		return "redirect:/";
    	}
    }
    
    // Logs out a user.
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    // Removes the session.
    session.removeAttribute("user_id");
    return "redirect:/";
    }
    
    // Routes to the new book page.
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
    	if(session.getAttribute("user_id") != null) {
    		return "/bookclubs/newBook.jsp";
    	}
    	else {
    		return "redirect:/";
    	}
    }
    
    // Creates a book, and redirects to the dashboard page.
    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/bookclubs/newBook.jsp";
    	}
    	else {
    		mainServ.createBook(book);
    		return "redirect:/dashboard";
    	}
    }
    
    // Routes to the show book page.
    @GetMapping("/books/{bookId}")
    public String showBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("user_id") != null) {
    		Book book = mainServ.oneBook(id);
        	model.addAttribute("book", book);
        	return "/bookclubs/showBook.jsp";
    	}
    	else {
    		return "redirect:/";
    	}
    }
    
    // Routes to the edit book page.
    @GetMapping("/books/{bookId}/edit")
    public String editBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("user_id") != null /*&& session.getAttribute("user_id") == */) {
    		Book book = mainServ.oneBook(id);
        	model.addAttribute("book", book);
        	return "/bookclubs/editBook.jsp";
    	}
    	/*else if(session.getAttribute("user_id") != null) {
    		Book book = mainServ.oneBook(id);
        	model.addAttribute("book", book);
        	return "redirect:/books/{bookId}";
    	}*/
    	else {
    		return "redirect:/";
    	}
    }
    
    // Updates a book, and redirects to the show book page.
    // WARNING this method creates a book instead of updating a book.
    @PutMapping("/books/{bookId}/edit")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "/books/{bookId}/edit.jsp";
    	}
    	else {
    		mainServ.updateBook(book);
    		return "redirect:/books/{bookId}";
    	}
    }
    
}