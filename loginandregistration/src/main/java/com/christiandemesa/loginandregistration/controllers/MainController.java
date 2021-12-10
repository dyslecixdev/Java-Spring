package com.christiandemesa.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christiandemesa.loginandregistration.models.LoginUser;
import com.christiandemesa.loginandregistration.models.User;
import com.christiandemesa.loginandregistration.services.UserService;

@Controller
public class MainController {
    
	@Autowired
    private UserService userServ;
    
	// Routes to the login and registration page.
    @GetMapping("/")
    public String index(Model model) {
    	// Adds both User and LoginUser to the same model.
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    // Registers a user.
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // Sessions the user's id.
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/home";
    }
    
    // Logs in a user.
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
    	User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    
    // Routes to the home page.
    @GetMapping("/home")
    public String home(HttpSession session) {
    	// If a user did not register or login, it redirects to the login and registration page.
    	if(session.getAttribute("user_id") != null) {
    		return "home.jsp";
    	}
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
    
}
