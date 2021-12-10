package com.christiandemesa.loginandregistration.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// This model is used to register a user.
@Entity
@Table(name="users")
public class User {
    
	// Member variables with validations and error messages.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // If you change the @Size of the member variables after successfully running the Spring application with a MySQL schema, you need to change the table data to match it.
    @NotEmpty(message="Username is required!")
    @Size(min=2, max=30, message="Username must be between 2 and 30 characters!")
    private String userName;
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    @NotEmpty(message="Password is required!")
    @Size(min=8, message="Password must be at least 8 characters!")
    private String password;
    // Transient does not save the member variable to the database (use for confirm passwords).
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, message="Confirm Password must be at least 8 characters!")
    private String confirm;
    /*@NotNull(message="Language is required!")
    private String language;
    @NotNull(message="Gender is required!")
    private String gender;
    private List<String> likes;*/
    
    // Add datepicker later.
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
  
    // Constructors
    public User() {
    }
    // Note how String confirm is not included because it is transient.
    public User(String userName, String email, String password/*, String language, String gender, List<String> likes*/) {
    	this.userName = userName;
    	this.email = email;
    	this.password = password;
    	/*this.language = language;
    	this.gender = gender;
    	this.likes = likes;*/
    }
    
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	/*public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}*/
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Created at and updated at
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
  
}
