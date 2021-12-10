package com.christiandemesa.loginandregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christiandemesa.loginandregistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
}

// A LoginUserRepository is not needed since none of the information there interacts with the database.