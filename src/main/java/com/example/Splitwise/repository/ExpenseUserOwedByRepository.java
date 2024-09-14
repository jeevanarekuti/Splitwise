package com.example.Splitwise.repository;

import com.example.Splitwise.models.ExpenseUserOwedBy;
import com.example.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserOwedByRepository extends JpaRepository<ExpenseUserOwedBy, Integer> {

    List<ExpenseUserOwedBy> findAllByUser(User user);
}
