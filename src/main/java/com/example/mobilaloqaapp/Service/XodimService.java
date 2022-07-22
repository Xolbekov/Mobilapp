package com.example.mobilaloqaapp.Service;

import com.example.mobilaloqaapp.DTO.FilialXodimDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.FilialXodim;
import com.example.mobilaloqaapp.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class XodimService {

    @Autowired
    XodimRepositary xodimRepositary;

    public ApiResponce createXodim(FilialXodimDTO filialXodimDTO){
        boolean b = xodimRepositary.existsByUsername(filialXodimDTO.getUsername());
        if (b){
            return new ApiResponce("Bunday xodim mavjud",false);
        }
        FilialXodim filialXodim=new FilialXodim();
        filialXodim.setFish(filialXodim.getFish());
        filialXodim.setUsername(filialXodimDTO.getUsername());
        filialXodim.setParol(filialXodimDTO.getParol());

        xodimRepositary.save(filialXodim);
        return new ApiResponce("Filialga xodim muvaffaqiyatli qo'shildi",true);

    }
    public ApiResponce deleteXodim(Integer id){
        Optional<FilialXodim> filialXodim=xodimRepositary.findById(id);
        if (!filialXodim.isPresent()){
            return new ApiResponce("Bunday xodim filialda mavjud emas",false);
        }
        xodimRepositary.deleteById(id);
        return new ApiResponce("Xodim o'chirib tashlandi",true);
    }

}
