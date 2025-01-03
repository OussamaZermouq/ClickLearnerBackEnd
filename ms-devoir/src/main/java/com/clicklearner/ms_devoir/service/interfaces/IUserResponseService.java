package com.clicklearner.ms_devoir.service.interfaces;

import com.clicklearner.ms_devoir.DTO.GradeSubmitionMutipleChoiceRequestDto;
import com.clicklearner.ms_devoir.model.userresponse.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface IUserResponseService {
    void submitStudentMultipleChoiceResponse(GradeSubmitionMutipleChoiceRequestDto gradeSubmitionMutipleChoiceRequestDto);
    List<UserResponse> getUserResponseByDevoirId(int userId, @RequestParam int devoirId);

}
