package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.service.implementations.MatierServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-cours/api/v1/matiere")
public class MatierController {

    @Autowired
    MatierServiceImpt matierService;

    @GetMapping("/")
    public List<Matier> getAllMatiers(){
        return matierService.getAllMatiers();
    }

    @GetMapping("/{id}")
    public Matier matierById(@PathVariable Long id){
        Matier matier = matierService.getMatierById(id);

        return matier;
    }

    @PostMapping("/create")
    public Matier addMatier(@RequestBody Matier matier) {
        return matierService.addMatier(matier);
    }

    @PutMapping("/update/{id}")
    public Matier updateMatier(@PathVariable Long id, @RequestBody Matier matier) {
        return matierService.updateMatier(id, matier);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMatier(@PathVariable Long id) {
        matierService.deleteMatier(id);
        return "Matière supprimée avec succès.";
    }

}
