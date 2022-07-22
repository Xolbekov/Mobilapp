package com.example.mobilaloqaapp.Service;

import com.example.mobilaloqaapp.DTO.FilialXodimDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.FilialXodim;
import com.example.mobilaloqaapp.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilialRaxbarService {

    @Autowired
    XodimRepositary xodimRepositary;

    public ApiResponce createFilialXodim(FilialXodimDTO filialXodimDTO){
        boolean b = xodimRepositary.existsByUsername(filialXodimDTO.getUsername());
        if (b){
            return new ApiResponce("Bunday xodim mavjud",false);
        }
        FilialXodim filialXodim=new FilialXodim();
        filialXodim.setFish(filialXodimDTO.getFish());
        filialXodim.setUsername(filialXodimDTO.getUsername());
        filialXodim.setParol(filialXodimDTO.getParol());

        xodimRepositary.save(filialXodim);
        return new ApiResponce("Xodim ro'yxatdan o'tkazildi",true);
    }

    public ApiResponce deleteFilialXodim(Integer id){
        Optional<FilialXodim> filialXodim=xodimRepositary.findById(id);
        if (!filialXodim.isPresent()){
            return new ApiResponce("Bunday xodim mavjud emas",false);
        }
        xodimRepositary.deleteById(id);
        return new ApiResponce("Xodim malumotlarni o'chirib tashlandi",true);
    }

}
