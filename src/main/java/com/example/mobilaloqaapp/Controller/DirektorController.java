package com.example.mobilaloqaapp.Controller;

import com.example.mobilaloqaapp.DTO.ManagerDTO;
import com.example.mobilaloqaapp.Model.ApiResponce;
import com.example.mobilaloqaapp.Model.Manager;
import com.example.mobilaloqaapp.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/DirektorController")
public class DirektorController {

    @Autowired
    ManagerService managerService;

    @PostMapping("/createManager")
    public HttpEntity<?> createManager(@RequestBody ManagerDTO managerDTO){
        ApiResponce apiResponce=managerService.createManager(managerDTO);
        return ResponseEntity.status(apiResponce.isHolat()?200:409).body(apiResponce);
    }
}
