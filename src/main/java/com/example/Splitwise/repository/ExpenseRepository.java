package com.example.Splitwise.repository;

import com.example.Splitwise.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findByIdIn(List<Integer> expenseIds);
}
