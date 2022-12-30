package com.programming.tochie.springbootmongodbtutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.PathVariable;

import com.programming.tochie.springbootmongodbtutorial.model.Expense;
import com.programming.tochie.springbootmongodbtutorial.repository.ExpenseRepository;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
        // expenseRepository.save(expense);
        System.out.println(expense); 
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException(
                    String.format("Can not find expense by id %s", expense.getId())
                ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

// TIS CODE CAN'T RUN
    public Expense getExpenseByName(String name){
       return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
            String.format("can not find expense by name %s", name)
        ));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }

    
}
