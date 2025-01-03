package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.service.implementations.CoursServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursController {
    @Autowired
    private CoursServiceImpt coursService;



    @GetMapping("/cours")
    public List<Cours> coursList(){
        return coursService.getAllcours();
    }

    @GetMapping("/cours/{id}")
    public Cours coursById(@PathVariable Long id){
        Cours cours = coursService.getCourById(id);

        return cours;
    }

    @PostMapping("/cours/upload")
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCour(cours);
    }

    @PutMapping("/cours/update/{id}")
    public Cours updateCours(@PathVariable Long id, @RequestBody Cours cours) {
        return coursService.updateCour(id, cours);
    }

    @DeleteMapping("/cours/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCour(id);
        return "Cours supprimé avec succès.";
    }
}

