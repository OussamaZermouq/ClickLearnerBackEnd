package com.clicklearner.ms_examen.ms_examen.controller;

import com.clicklearner.ms_examen.ms_examen.Dto.ResponseDto;
import com.clicklearner.ms_examen.ms_examen.model.Examen;
import com.clicklearner.ms_examen.ms_examen.service.Implementations.ExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/examen")
public class ExamenController {
    @Autowired
    public ExamenServiceImpl examenService;

    @GetMapping("/{examenId}")
    public ResponseEntity<?> getExamenById(@PathVariable int examenId){
        Examen examen = examenService.getExamenById(examenId);
        if (examen!=null){
            return ResponseEntity.ok().body(examen);
        }
        else{
            return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Examen not found with this ID"));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createExamen(@RequestBody Examen examen){
        examenService.createExamen(examen);
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "Examen has been created"));
    }

    @GetMapping("/getexamenbycoursid/{courId}")
    public ResponseEntity<?> getExamenByCoursId(@PathVariable int coursId){
        List<Examen> examen = examenService.getExamenForCours(coursId);
        if (examen!=null){
            return ResponseEntity.ok().body(examen);
        }
        else{
            return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Examen not found for this cours ID"));
        }
    }

}
