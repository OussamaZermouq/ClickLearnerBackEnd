package com.clicklearner.ms_devoir.service.implementations;

import com.clicklearner.ms_devoir.DTO.GradeSubmitionMutipleChoiceRequestDto;
import com.clicklearner.ms_devoir.model.question.Choix;
import com.clicklearner.ms_devoir.model.question.Question;
import com.clicklearner.ms_devoir.model.userresponse.MultipleChoiceResponse;
import com.clicklearner.ms_devoir.model.userresponse.UserResponse;
import com.clicklearner.ms_devoir.repository.ChoixRepository;
import com.clicklearner.ms_devoir.repository.QuestionRepository;
import com.clicklearner.ms_devoir.repository.UserResponseRepository;
import com.clicklearner.ms_devoir.service.interfaces.IUserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class UserResponseServiceImpl implements IUserResponseService {
    @Autowired
    private UserResponseRepository userResponseRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoixRepository choixRepository;
    @Override
    public void submitStudentMultipleChoiceResponse(GradeSubmitionMutipleChoiceRequestDto gradeSubmitionMutipleChoiceRequestDto) {
        Optional<Question> optionalQuestion = questionRepository.findById(gradeSubmitionMutipleChoiceRequestDto.getQuestionId());
        Optional<Choix> optionalChoix = choixRepository.findById(gradeSubmitionMutipleChoiceRequestDto.getChoixId());
        if (optionalQuestion.isPresent() && optionalChoix.isPresent()){
            MultipleChoiceResponse userResponse = new MultipleChoiceResponse(0, optionalQuestion.get(), gradeSubmitionMutipleChoiceRequestDto.getStudentId(), new Date(), optionalChoix.get());
            userResponseRepository.save(userResponse);
        }

    }

    @Override
    public List<UserResponse> getUserResponseByDevoirId(@RequestParam int userId, @RequestParam int devoirId) {
        Optional<List<UserResponse>> userResponses = userResponseRepository.findUserresponseByDevoirId(userId, devoirId);
        if (userResponses.isPresent()){
            return userResponses.get();
        }
        return null;
    }
}
