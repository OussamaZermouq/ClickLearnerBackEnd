package com.clicklearner.ms_devoir.service.implementations;

import com.clicklearner.ms_devoir.model.Choix;
import com.clicklearner.ms_devoir.model.Devoir;
import com.clicklearner.ms_devoir.model.MultipleChoiceQuestion;
import com.clicklearner.ms_devoir.model.Question;
import com.clicklearner.ms_devoir.openfeign.UserServiceClient;
import com.clicklearner.ms_devoir.repository.DevoirRepository;
import com.clicklearner.ms_devoir.service.interfaces.IDevoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevoirServiceImpl implements IDevoirService {
    @Autowired
    public DevoirRepository devoirRepository;

    @Autowired
    public UserServiceClient userServiceClient;

    @Override
    public void addDevoir(Devoir devoir) {
        if (devoir.getQuestions() != null) {
            for (Question question : devoir.getQuestions()) {
                question.setDevoir(devoir);
                if (question instanceof MultipleChoiceQuestion) {
                    MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
                    if (mcq.getChoixList() != null) {
                        for (Choix choix : mcq.getChoixList()) {
                            choix.setQuestion(mcq);
                        }
                    }
                    if (mcq.getCorrectAnswer() != null) {
                        mcq.getCorrectAnswer().setQuestion(mcq);
                    }
                }
            }
        }
        devoirRepository.save(devoir);
    }


    @Override
    public void updateDevoir(Devoir devoir, int devoirId) {
        Optional<Devoir> devoirToUpdate = devoirRepository.findById(devoirId);
        if (devoirToUpdate.isPresent()){
            devoirRepository.save(devoirToUpdate.get());
        }
    }

    @Override
    public Devoir getDevoirById(int devoirId) {
        Optional<Devoir> devoir = devoirRepository.findById(devoirId);
        if(devoir.isPresent()){
            return devoir.get();
        }
        return null;
    }

    @Override
    public List<Devoir> getAllDevoirs() {
        List<Devoir> devoirs = devoirRepository.findAll();
        return devoirs;
    }

    @Override
    public List<Devoir> getDevoirForCourse(int courseId) {
        return null;
    }

    @Override
    public void deleteDevoir(int devoirId) {
        Optional<Devoir> devoir = devoirRepository.findById(devoirId);
        if (devoir.isPresent()){
            devoirRepository.delete(devoir.get());
        }
    }
}
