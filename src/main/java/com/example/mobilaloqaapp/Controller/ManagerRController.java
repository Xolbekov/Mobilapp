package com.example.mobilaloqaapp.Controller;

import com.example.mobilaloqaapp.DTO.MijozDTO;
import com.example.mobilaloqaapp.Model.Mijoz;
import com.example.mobilaloqaapp.Model.Simkarta;
import com.example.mobilaloqaapp.Repositary.MijozRepositary;
import com.example.mobilaloqaapp.Repositary.SimkartaRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/simkartaController")
public class ManagerRController {

   @Autowired
   MijozRepositary mijozRepositary;

    @Autowired
    SimkartaRepositary simkartaRepositary;

    @Transactional
    @PostMapping
    public HttpEntity<?> createSimkarta(@RequestBody MijozDTO mijozDTO){
        Mijoz mijoz=new Mijoz();
        mijoz.setFish(mijozDTO.getFish());
        mijoz.setUsername(mijozDTO.getUsername());
        mijoz.setParol(mijozDTO.getParol());
        mijoz.setReparol(mijozDTO.getReparol());
        mijoz.setShaxs(mijozDTO.getShaxs());

        List<Simkarta> simkartaList=new ArrayList<>();
        for (Simkarta simkarta:mijozDTO.getSimkartaList()) {
            Simkarta simkarta1=new Simkarta(simkarta.getKompaniya(),simkarta.getTarifReja(),simkarta.getTelRaqam(),mijoz);
            simkartaList.add(simkarta1);
        }
        mijoz.setSimkartaList(simkartaList);
        mijozRepositary.save(mijoz);
        return ResponseEntity.ok().body("Simkarta saqlandi");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        try{
            simkartaRepositary.deleteById(id);
            return ResponseEntity.ok("O'chirildi");
        }
        catch (Exception e){
            return ResponseEntity.ok("O'chirib bo'lmadi");
        }
    }

    @GetMapping("/select")
    public HttpEntity<?> select(){
        return ResponseEntity.ok().body(simkartaRepositary.findAll());
    }

}
