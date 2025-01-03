package com.clicklearner.ms_devoir.controller;


import com.clicklearner.ms_devoir.DTO.DevoirDTO;
import com.clicklearner.ms_devoir.DTO.ResponseDTO;
import com.clicklearner.ms_devoir.model.Devoir;
import com.clicklearner.ms_devoir.service.implementations.DevoirServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/devoir")
public class DevoirController {

    @Autowired
    public DevoirServiceImpl devoirService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{devoirId}")
    @ResponseBody
    public ResponseEntity<?> getDevoirById(@PathVariable int devoirId){
        DevoirDTO devoir = devoirService.getDevoirById(devoirId);
        if (devoir!=null){
            return ResponseEntity.ok().body(devoirService.getDevoirById(devoirId));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.NOT_FOUND, "Devoir not found with id "+ devoirId));

    }

    @PostMapping("/adddevoir")
    public ResponseEntity<ResponseDTO> addDevoir(@RequestBody Devoir devoir){
        devoirService.addDevoir(devoir);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir created successfully"));

    }
    @PutMapping("/updatedevoir/{devoirId}")
    public ResponseEntity<ResponseDTO> updateDevoir(@RequestBody Devoir devoir, @PathVariable int devoirId){
        devoirService.updateDevoir(devoir, devoirId);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir updated successfully"));

    }
    @DeleteMapping("/deletedevoir/{devoirId}")
    public ResponseEntity<ResponseDTO> deleteDevoir(@PathVariable int devoirId){
        devoirService.deleteDevoir(devoirId);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir deleted successfully"));
    }

    @GetMapping("/cours/{coursId}")
    public ResponseEntity<?> getDevoirByCoursId(@PathVariable int coursId){
        List<Devoir> devoirs = devoirService.getDevoirbyCoursId(coursId);
        if (devoirs!=null){
            return ResponseEntity.ok().body(devoirs);
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "No devoir has been found for this cours"));
    }

    @GetMapping("/student/{userId}")
    public ResponseEntity<?> getAllDevoirForStudent(@PathVariable int userId){
        List<Devoir> devoirsForStudent = devoirService.getAllDevoirsForStudent(userId);
        if (devoirsForStudent!=null){
            return ResponseEntity.ok().body(devoirsForStudent);
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "No devoirs have been found for this student"));

    }

    private DevoirDTO convertToDto(Devoir devoir){
        DevoirDTO devoirDTO = modelMapper.map(devoir, DevoirDTO.class);
        return devoirDTO;
    }
}
