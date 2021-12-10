package com.christiandemesa.loginandregistration.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// Notice there is no @Entity.
public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, message="Password must be at least 8 characters")
    private String password;
    
    // Constructor
    public LoginUser() {
    }
    
    // Getters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    // Created at and updated at not necessary since this information is not saved to the database.
    
}