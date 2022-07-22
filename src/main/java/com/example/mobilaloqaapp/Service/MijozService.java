package com.example.mobilaloqaapp.Service;

import com.example.mobilaloqaapp.DTO.MijozDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.Mijoz;
import com.example.mobilaloqaapp.Repositary.MijozRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MijozService {

    @Autowired
    MijozRepositary mijozRepositary;

    public ApiResponce createMijoz(MijozDTO mijozDTO){
        boolean b = mijozRepositary.existsByUsername(mijozDTO.getUsername());
        if (b){
            return new ApiResponce("Bunday usernamedagi mijoz mavjud",false);
        }
        Mijoz mijoz=new Mijoz();
        mijoz.setFish(mijozDTO.getFish());
        mijoz.setUsername(mijozDTO.getUsername());
        mijoz.setParol(mijozDTO.getParol());
        mijoz.setReparol(mijozDTO.getReparol());
        mijoz.setShaxs(mijozDTO.getShaxs());
        mijozRepositary.save(mijoz);
        return new ApiResponce("Tabriklaymiz siz ro'yxatdan o'tdingiz !",true);
    }
    public ApiResponce updateMijoz(Integer id,MijozDTO mijozDTO){
        Optional<Mijoz> mijoz=mijozRepositary.findById(id);
        if (!mijoz.isPresent()){
            return new ApiResponce("Bunday mijoz mavjud emas",false);
        }
        if (mijozDTO.getParol().equals(mijozDTO.getReparol())){
            Mijoz mijoz1=mijoz.get();
            mijoz1.setFish(mijozDTO.getFish());
            mijoz1.setUsername(mijozDTO.getUsername());
            mijoz1.setParol(mijozDTO.getParol());
            mijoz1.setReparol(mijozDTO.getReparol());
            mijoz1.setShaxs(mijozDTO.getShaxs());

            mijozRepositary.save(mijoz1);
            return new ApiResponce("Malumotlaringiz muvaffaqiyatli tahrirlandi !",true);
        }
        return new ApiResponce("Qayta urinib ko'ring",false);
    }

    public HttpEntity<?> selectMijoz(){
        return ResponseEntity.ok().body(mijozRepositary.findAll());
    }
}
