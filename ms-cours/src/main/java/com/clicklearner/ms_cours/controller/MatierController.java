package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.MatierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatierController {
    @Autowired
    private MatierRepository matierRepository;


    @GetMapping("/matiers")
    public List<Matier> matierList(){
        return matierRepository.findAll();
    }

    @GetMapping("/matiers/{id}")
    public Matier matierById(@PathVariable Long id){
        return matierRepository.findById(id).get();
    }
}
