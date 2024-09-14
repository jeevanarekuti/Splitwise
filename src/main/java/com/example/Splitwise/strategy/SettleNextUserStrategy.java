package com.example.Splitwise.strategy;

import com.example.Splitwise.models.Expense;
import com.example.Splitwise.models.Transaction;

import java.util.List;

public class SettleNextUserStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settle(List<Expense> expenseList) {
        return null;
    }
}
