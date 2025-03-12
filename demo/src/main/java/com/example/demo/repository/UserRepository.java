package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    // JpaRepository provides built-in CRUD methods    
    // this is made so we do not have to write SQL queries and instead use built in methods like
    // findAll(), save(), deleteById()
}