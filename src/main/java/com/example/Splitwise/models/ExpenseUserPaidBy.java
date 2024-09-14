package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ExpenseUserPaidBy extends BaseModel{
    @ManyToOne
    private Expense expense;
    @OneToOne
    private User user;
    private double amount;
}
