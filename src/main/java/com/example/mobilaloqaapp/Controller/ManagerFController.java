package com.example.mobilaloqaapp.Controller;

import com.example.mobilaloqaapp.DTO.FilialXodimDTO;
import com.example.mobilaloqaapp.DTO.ManagerDTO;
import com.example.mobilaloqaapp.DTO.RaxbarDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.FilialXodim;
import com.example.mobilaloqaapp.Service.RaxbarService;
import com.example.mobilaloqaapp.Service.XodimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ManagerFColtroller")
public class ManagerFController {

    @Autowired
    RaxbarService raxbarService;

    @Autowired
    XodimService xodimService;

    @PostMapping("/createRaxbar")
    public HttpEntity<?> createRaxbar(@RequestBody RaxbarDTO raxbarDTO){
        ApiResponce apiResponce=raxbarService.createRaxbar(raxbarDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

    @PostMapping("/createXodim")
    public HttpEntity<?> createXodim(@RequestBody FilialXodimDTO filialXodimDTO){
        ApiResponce apiResponce=xodimService.createXodim(filialXodimDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

    @DeleteMapping("/deleteXodim/{id}")
    public HttpEntity<?> deleteXodim(@PathVariable Integer id){
        ApiResponce apiResponce=xodimService.deleteXodim(id);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }
}
