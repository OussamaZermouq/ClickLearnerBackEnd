package com.clicklearner.ms_devoir.service.implementations;

import com.clicklearner.ms_devoir.model.Question;
import com.clicklearner.ms_devoir.repository.QuestionRepository;
import com.clicklearner.ms_devoir.service.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void updateQuetion(Question question, int questionId) {
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(int questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public Question getQuestionById(int questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        return question.get();
    }

}
