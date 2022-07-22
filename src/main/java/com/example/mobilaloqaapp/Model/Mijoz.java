package com.example.mobilaloqaapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Mijoz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String fish;
    public String username;
    public String parol;
    public String reparol;
    public String shaxs;

    @OneToMany(mappedBy = "mijoz",cascade = CascadeType.ALL)
    List<Simkarta> simkartaList;
}
