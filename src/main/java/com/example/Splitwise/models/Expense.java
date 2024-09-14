package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Expense extends BaseModel{
    private double amount;
    private Date dateOfExpense;
    private String description;
    private ExpenseStatus status;

    private List<ExpenseUserPaidBy> paidBy;
    private List<ExpenseUserOwedBy> owedBy;
}
