package com.example.Splitwise.repository;

import com.example.Splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User save(User user);
    User findById(int id);
}
