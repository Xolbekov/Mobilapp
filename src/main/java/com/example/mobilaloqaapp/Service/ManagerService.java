package com.example.mobilaloqaapp.Service;

import com.example.mobilaloqaapp.DTO.ManagerDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.Manager;
import com.example.mobilaloqaapp.Repositary.ManagerRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManagerRepositary managerRepositary;

    public ApiResponce createManager(ManagerDTO managerDTO){
        boolean b = managerRepositary.existsByUsername(managerDTO.getUsername());
        if (b){
            return new ApiResponce("Bunday Manager mavjud!",false);
        }
        Manager manager=new Manager();
        manager.setFish(managerDTO.getFish());
        manager.setUsername(managerDTO.getUsername());
        manager.setParol(managerDTO.getParol());
        manager.setLavozim(managerDTO.getLavozim());
        managerRepositary.save(manager);
        return new ApiResponce("Manager muvaffaqiyatli qo'shildi",true);
    }

}
