package com.example.Splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Transaction extends BaseModel{
    private int paid;
    private int owed;
    private double amount;
}
