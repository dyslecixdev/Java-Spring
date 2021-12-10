package com.christiandemesa.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christiandemesa.bookclub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    // A query to find the user by their email.
    Optional<User> findByEmail(String email);
    
    // This query finds all the users.
    List<User> findAll();
    
}