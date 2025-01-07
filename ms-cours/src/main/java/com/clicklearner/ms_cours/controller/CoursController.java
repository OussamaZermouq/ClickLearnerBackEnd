package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.dto.CoursDto;
import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.service.implementations.CoursServiceImpt;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/ms-cours/api/v1/cours")
public class CoursController {
    @Autowired
    private CoursServiceImpt coursService;

    @GetMapping("/")
    public List<Cours> coursList(){
        return coursService.getAllcours();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDto> coursById(@PathVariable Long id){
        CoursDto coursDto = coursService.getCourById(id);
        return ResponseEntity.ok().body(coursDto);
    }



    @PostMapping(value = "/create")
    public ResponseEntity<?> addCours(@RequestBody Cours cours) {
        coursService.addCour(cours);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long id, @RequestBody Cours cours) {

        return ResponseEntity.ok().body(coursService.updateCour(id, cours));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCour(id);
        return "Cours supprimé avec succès.";
    }
}

