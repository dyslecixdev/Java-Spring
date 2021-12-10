package com.christiandemesa.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.christiandemesa.loginandregistration.models.LoginUser;
import com.christiandemesa.loginandregistration.models.User;
import com.christiandemesa.loginandregistration.repositories.UserRepository;

@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepo;
    
	// This method registers a user.
    public User register(User newUser, BindingResult result) {
    	// Avoids registering another user with the same email.
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        // Checks if password and confirm password are the same.
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	// This is the error message.
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        // Does nothing if the user does not meet the validations from the model.
        if(result.hasErrors()) {
            return null;
        } 
        // This hashes the password, and creates a user in the database.
        else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    // This method logs in a user.
    public User login(LoginUser newLogin, BindingResult result) {
    	// Does nothing if the user does not meet the validations in the model.
        if(result.hasErrors()) {
            return null;
        }
        // Creates a container object of one user's information from the database with the logged in email.
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        // If the logged in email does not match any user in the database, run this error.
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        // Creates a variable to store the information from the container object.
        User user = potentialUser.get();
        // If the logged in password does not match the password in the database, run this error.
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
    
}
