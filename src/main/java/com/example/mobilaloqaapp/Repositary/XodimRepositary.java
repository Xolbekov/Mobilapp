package com.example.mobilaloqaapp.Repositary;

import com.example.mobilaloqaapp.Model.FilialXodim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XodimRepositary extends JpaRepository<FilialXodim,Integer> {
    boolean existsByUsername(String username);
}
