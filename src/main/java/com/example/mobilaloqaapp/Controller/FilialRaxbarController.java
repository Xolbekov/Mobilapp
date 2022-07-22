package com.example.mobilaloqaapp.Controller;

import com.example.mobilaloqaapp.DTO.FilialXodimDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Service.FilialRaxbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/FilialRaxbarController")
public class FilialRaxbarController {

    @Autowired
    FilialRaxbarService filialRaxbarService;

    @PostMapping
    public HttpEntity<?> createFilialXodim(@RequestBody FilialXodimDTO filialXodimDTO){
        ApiResponce apiResponce=filialRaxbarService.createFilialXodim(filialXodimDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleleFilialXodim(@PathVariable Integer id){
        ApiResponce apiResponce=filialRaxbarService.deleteFilialXodim(id);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }

}
