package com.example.mobilaloqaapp.Service;

import com.example.mobilaloqaapp.DTO.RaxbarDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.RaxbarFilial;
import com.example.mobilaloqaapp.Repositary.RaxbarRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaxbarService {

    @Autowired
    RaxbarRepositary raxbarRepositary;

    public ApiResponce createRaxbar(RaxbarDTO raxbarDTO){
        RaxbarFilial raxbarFilial=new RaxbarFilial();
        raxbarFilial.setFish(raxbarDTO.getFish());
        raxbarFilial.setUsername(raxbarDTO.getUsername());
        raxbarFilial.setParol(raxbarDTO.getParol());

        raxbarRepositary.save(raxbarFilial);
        return new ApiResponce("Raxbar muvaffaqiyatli joylandi",true);
    }

}
