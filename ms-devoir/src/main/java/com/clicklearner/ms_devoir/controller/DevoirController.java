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
        Devoir devoir = devoirService.getDevoirById(devoirId);
        if (devoir!=null){
            return ResponseEntity.ok().body(convertToDto(devoirService.getDevoirById(devoirId)));
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.NOT_FOUND, "Devoir not found with id "+String.valueOf(devoirId)));

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

    private DevoirDTO convertToDto(Devoir devoir){
        DevoirDTO devoirDTO = modelMapper.map(devoir, DevoirDTO.class);
        return devoirDTO;
    }
}
