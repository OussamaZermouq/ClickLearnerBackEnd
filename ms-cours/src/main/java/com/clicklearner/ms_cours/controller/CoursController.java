package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoursController {
    @Autowired
    private CoursRepository coursRepository;



    @GetMapping("/cours")
    public List<Cours> coursList(){
        return coursRepository.findAll();
    }

    @GetMapping("/cours/{id}")
    public Cours coursById(@PathVariable Long id){
        return coursRepository.findById(id).get();
    }
}
