package com.programming.tochie.springbootmongodbtutorial.repository;


// import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.programming.tochie.springbootmongodbtutorial.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{
    @Query("{'name: ?0'}")
   Optional<Expense> findByName(String name);
    
}

