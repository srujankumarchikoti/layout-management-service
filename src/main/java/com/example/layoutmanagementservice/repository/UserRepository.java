package com.example.layoutmanagementservice.repository;

import com.example.layoutmanagementservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
