package com.clicklearner.msprogression.controller;

import com.clicklearner.msprogression.dto.ProgressionDto;
import com.clicklearner.msprogression.dto.ResponseDto;
import com.clicklearner.msprogression.model.Progression;
import com.clicklearner.msprogression.service.implementations.ProgressionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ms-progression/api/v1/progression")
public class ProgressionController {

    @Autowired
    private ProgressionServiceImpl progressionService;

    @GetMapping("/")
    public ResponseEntity<?> getProgressionForCoursAndUser(@RequestParam("userId") int userId, @RequestParam("coursId") int coursId){
        ProgressionDto progression = progressionService.getProgressionByCoursIdAndUserId(coursId,userId);
        if (progression!=null){
            return ResponseEntity.ok().body(progression);
        }
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Couldn't find this progression"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProgression(@RequestBody Progression progression){
        progressionService.updateProgression(progression);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProgression(@RequestBody Progression progression){
        Progression progressionOut = progressionService.createProgression(progression);
        if (progression!=null){
            return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "Successfully created a progression"));

        }
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't create a progression"));
    }
}
