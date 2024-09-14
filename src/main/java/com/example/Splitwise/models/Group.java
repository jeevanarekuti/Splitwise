package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Group extends BaseModel {
    private String groupName;
    private List<Expense> expenseList;
    private List<User>users;
    private List<User>admins;
    private List<Transaction> transactionList;

}
