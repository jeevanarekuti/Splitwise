package com.example.Splitwise.repository;

import com.example.Splitwise.models.ExpenseUserPaidBy;
import com.example.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserPaidByRepository extends JpaRepository<ExpenseUserPaidBy,Integer> {
    List<ExpenseUserPaidBy> findAllByUser(User user);
}
