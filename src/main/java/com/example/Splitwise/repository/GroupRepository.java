package com.example.Splitwise.repository;

import com.example.Splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findById(int groupId);
}
