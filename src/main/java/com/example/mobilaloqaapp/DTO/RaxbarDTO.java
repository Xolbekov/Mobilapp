package com.example.mobilaloqaapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RaxbarDTO {
    public String fish;
    public String username;
    public String parol;
}
