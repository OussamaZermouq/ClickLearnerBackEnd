package com.clicklearner.ms_cours.controller;


import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.repository.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapitreController {
    @Autowired
    private ChapitreRepository chapitreRepository;


    @GetMapping("/chapitres")
    public List<Chapitre> chapitreList(){
        return chapitreRepository.findAll();
    }

    @GetMapping("/chapitres/{id}")
    public Chapitre chapitreById(@PathVariable Long id){
        return chapitreRepository.findById(id).get();
    }
}
