package com.example.mobilaloqaapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RaxbarFilial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false)
    public String fish;
    @Column(nullable = false)
    public String username;
    @Column(nullable = false)
    public String parol;
}
