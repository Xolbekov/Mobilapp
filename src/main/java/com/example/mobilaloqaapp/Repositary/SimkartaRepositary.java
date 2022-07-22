package com.example.mobilaloqaapp.Repositary;

import com.example.mobilaloqaapp.Model.Simkarta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimkartaRepositary extends JpaRepository<Simkarta,Integer> {
    boolean existsByTelRaqam(String telRaqam);
}
