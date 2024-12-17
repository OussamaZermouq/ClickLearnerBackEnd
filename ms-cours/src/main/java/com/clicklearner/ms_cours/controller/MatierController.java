package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.implementations.MatierServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
