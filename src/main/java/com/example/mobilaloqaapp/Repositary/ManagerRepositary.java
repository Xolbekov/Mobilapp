package com.example.mobilaloqaapp.Repositary;

import com.example.mobilaloqaapp.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepositary extends JpaRepository<Manager,Integer> {
    boolean existsByUsername(String username);
}
