package com.clicklearner.ms_devoir.controller;


import com.clicklearner.ms_devoir.DTO.GradeSubmitionMutipleChoiceRequestDto;
import com.clicklearner.ms_devoir.DTO.ResponseDTO;
import com.clicklearner.ms_devoir.DTO.UserResponseByDevoirRequest;
import com.clicklearner.ms_devoir.model.UserResponse;
import com.clicklearner.ms_devoir.service.implementations.UserResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userresponse")
public class UserResponseController {
    @Autowired
    private UserResponseServiceImpl userResponseService;


    @PostMapping("/submit")
    public ResponseEntity<ResponseDTO> submitMultipleChoiceQuestion(
            @RequestBody GradeSubmitionMutipleChoiceRequestDto gradeSubmitionMutipleChoiceRequest){
        userResponseService.submitStudentMultipleChoiceResponse(gradeSubmitionMutipleChoiceRequest);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "Your answer has been submitted"));
    }

    @GetMapping("/devoir")
    public ResponseEntity<?> getUserResponseForDevoirId(
            @RequestParam int userId,
            @RequestParam int devoirId){
        System.out.println("CALLED");
        List<UserResponse> userResponses = userResponseService.getUserResponseByDevoirId(userId, devoirId);
        if (!userResponses.isEmpty()){
            return ResponseEntity.ok().body(userResponses);
        }
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.NOT_FOUND, "Couldn't find the submission for this devoir"));

    }

}
