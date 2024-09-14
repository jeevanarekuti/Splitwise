package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ExpenseUserOwedBy extends BaseModel{
    @ManyToOne
    private Expense expense;
    @OneToOne
    private User user;
    private double amount;
}
