package com.clicklearner.ms_devoir.service.interfaces;


import com.clicklearner.ms_devoir.model.Question;
import org.springframework.stereotype.Service;


@Service
public interface IQuestionService {
    public void addQuestion(Question question);
    public void updateQuetion(Question question, int questionId);
    public void deleteQuestion(int questionId);
    public Question getQuestionById(int questionId);

}
