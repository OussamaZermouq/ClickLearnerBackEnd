package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.service.implementations.MatierServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatierController {

    @Autowired
    MatierServiceImpt matierService;

    @GetMapping("/matiers")
    public List<Matier> getAllMatiers(){
        return matierService.getAllMatiers();
    }

    @GetMapping("/matiers/{id}")
    public Matier matierById(@PathVariable Long id){
        Matier matier = matierService.getMatierById(id);

        return matier;
    }

    @PostMapping("/matiers/upload")
    public Matier addMatier(@RequestBody Matier matier) {
        return matierService.addMatier(matier);
    }

    @PutMapping("/matiers/update/{id}")
    public Matier updateMatier(@PathVariable Long id, @RequestBody Matier matier) {
        return matierService.updateMatier(id, matier);
    }

    @DeleteMapping("/matiers/delete/{id}")
    public String deleteMatier(@PathVariable Long id) {
        matierService.deleteMatier(id);
        return "Matière supprimée avec succès.";
    }


}
