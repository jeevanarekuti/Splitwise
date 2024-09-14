package com.example.Splitwise.strategy;

import com.example.Splitwise.models.Expense;
import com.example.Splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settle(List<Expense> expenseList);
}
