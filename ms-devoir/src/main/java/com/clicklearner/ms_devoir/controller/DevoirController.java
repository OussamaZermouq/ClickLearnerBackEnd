package com.clicklearner.ms_devoir.controller;


import com.clicklearner.ms_devoir.DTO.ResponseDTO;
import com.clicklearner.ms_devoir.model.Devoir;
import com.clicklearner.ms_devoir.service.implementations.DevoirServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/devoir")
public class DevoirController {

    @Autowired
    public DevoirServiceImpl devoirService;
    @GetMapping("/{devoirId}")
    public ResponseEntity<Devoir> getDevoirById(@RequestParam int devoirId){
        return ResponseEntity.ok().body(devoirService.getDevoirById(devoirId));
    }

    @PostMapping("/adddevoir")
    public ResponseEntity<ResponseDTO> addDevoir(@RequestBody Devoir devoir){
        devoirService.addDevoir(devoir);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir created successfully"));

    }
    @PutMapping("/updatedevoir/{devoirId}")
    public ResponseEntity<ResponseDTO> updateDevoir(@RequestBody Devoir devoir, @RequestParam int devoirId){
        devoirService.updateDevoir(devoir, devoirId);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir updated successfully"));

    }
    @DeleteMapping("/deletedevoir/{devoirId}")
    public ResponseEntity<ResponseDTO> deleteDevoir(@RequestParam int devoirId){
        devoirService.deleteDevoir(devoirId);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Devoir deleted successfully"));
    }
}
