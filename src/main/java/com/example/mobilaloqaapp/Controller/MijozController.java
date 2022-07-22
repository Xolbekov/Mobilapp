package com.example.mobilaloqaapp.Controller;

import com.example.mobilaloqaapp.DTO.MijozDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Service.MijozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/MijozController")
public class MijozController {

    @Autowired
    MijozService mijozService;

    @PostMapping("/createMijoz")
    public HttpEntity<?> createMijoz(@RequestBody MijozDTO mijozDTO){
        ApiResponce apiResponce=mijozService.createMijoz(mijozDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

    @PutMapping("/updateMijoz/{id}")
    public HttpEntity<?> updateMijoz(@PathVariable Integer id,@RequestBody MijozDTO mijozDTO){
        ApiResponce apiResponce=mijozService.updateMijoz(id,mijozDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

    @GetMapping("/selectMijoz")
    public HttpEntity<?> selectMijoz(){
        return ResponseEntity.ok().body(mijozService.selectMijoz());
    }

}
