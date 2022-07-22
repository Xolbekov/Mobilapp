package com.example.mobilaloqaapp.DTO;

import com.example.mobilaloqaapp.Model.Mijoz;
import com.example.mobilaloqaapp.Model.Simkarta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MijozDTO {
    public String fish;
    public String username;
    public String parol;
    public String reparol;
    public String shaxs;
    public List<Simkarta> simkartaList;
}
