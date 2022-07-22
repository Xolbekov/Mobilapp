package com.example.mobilaloqaapp.Repositary;

import com.example.mobilaloqaapp.Model.Mijoz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MijozRepositary extends JpaRepository<Mijoz,Integer> {
    boolean existsByUsername(String username);
}
