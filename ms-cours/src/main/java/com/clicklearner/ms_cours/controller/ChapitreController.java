package com.clicklearner.ms_cours.controller;


import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.ChapitreRepository;
import com.clicklearner.ms_cours.service.implementations.ChapitreServiceImpt;
import com.clicklearner.ms_cours.service.implementations.MatierServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapitreController {
    @Autowired
    ChapitreServiceImpt chapitreService;


    @GetMapping("/chapitres")
    public List<Chapitre> chapitreList(){
        return chapitreService.getAllChapitres();
    }

    @GetMapping("/chapitres/{id}")
    public Chapitre chapitreById(@PathVariable Long id){
        Chapitre chapitre = chapitreService.getChapitreById(id);

        return chapitre;
    }
}
