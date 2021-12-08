package com.christiandemesa.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christiandemesa.pokebook.models.Expense;
import com.christiandemesa.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    
	// Injects the ExpenseRepository as a dependency.
    @Autowired
	ExpenseRepository expRepo;
    
    // This method creates an expense.
    public Expense createExpense(Expense exp) {
    	return expRepo.save(exp);
    }
    
    // This method returns all the expenses.
    public List<Expense> allExpenses() {
    	return expRepo.findAll();
    }
    
	// This method returns one expense.
    public Expense oneExpense(Long id) {
    	Optional<Expense> optionalExp = expRepo.findById(id);
    	if(optionalExp.isPresent()) {
    		return optionalExp.get();
    	}
    	else {
    		return null;
    	}
    }
    
    public Expense updateExpense(Expense exp) {
    	return expRepo.save(exp);
    }
    
}
