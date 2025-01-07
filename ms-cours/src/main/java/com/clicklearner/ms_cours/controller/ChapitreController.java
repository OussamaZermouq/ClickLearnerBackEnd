package com.clicklearner.ms_cours.controller;


import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.service.implementations.ChapitreServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-cours/api/v1/chapitre")
public class ChapitreController {
    @Autowired
    ChapitreServiceImpt chapitreService;


    @GetMapping("/")
    public List<Chapitre> chapitreList(){
        return chapitreService.getAllChapitres();
    }

    @GetMapping("/{id}")
    public Chapitre chapitreById(@PathVariable Long id){
        Chapitre chapitre = chapitreService.getChapitreById(id);

        return chapitre;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> addChapitre(@RequestBody Chapitre chapitre) {
        try {
            chapitreService.addChapitre(chapitre);
            return ResponseEntity.ok("Chapitre ajouté avec succès !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateChapitre(@PathVariable Long id, @RequestBody Chapitre updatedChapitre) {
        try {
            chapitreService.updateChapitre(id, updatedChapitre);
            return ResponseEntity.ok("Chapitre mis à jour avec succès !");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChapitre(@PathVariable Long id) {
        chapitreService.deleteChapitre(id);
        return ResponseEntity.ok("Chapitre supprimé avec succès !");
    }
}
