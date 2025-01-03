package com.clicklearner.ms_devoir.service.implementations;

import com.clicklearner.ms_devoir.DTO.DevoirDTO;
import com.clicklearner.ms_devoir.DTO.UserDto;
import com.clicklearner.ms_devoir.model.question.Choix;
import com.clicklearner.ms_devoir.model.Devoir;
import com.clicklearner.ms_devoir.model.question.MultipleChoiceQuestion;
import com.clicklearner.ms_devoir.model.question.Question;
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
        if (devoirToUpdate.isPresent()) {
            devoirRepository.save(devoirToUpdate.get());
        }
    }

    @Override
    public DevoirDTO getDevoirById(int devoirId) {
        Optional<Devoir> devoir = devoirRepository.findById(devoirId);

        if (devoir.isPresent()) {
            Optional<UserDto> userDto = userServiceClient.getUserById(devoir.get().getProfId());
            return DevoirDTO.builder().
                    devoirId(devoirId).
                    title(devoir.get().getTitle()).
                    deadline(devoir.get().getDeadline()).
                    coursId(devoir.get().getCoursId()).
                    prof(userDto.get()).
                    questions(devoir.get().getQuestions()).
                    build();

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
        if (devoir.isPresent()) {
            devoirRepository.delete(devoir.get());
        }
    }

    @Override
    public List<Devoir> getDevoirbyCoursId(int coursId) {
        List<Devoir> devoirsForCoursId = devoirRepository.getDevoirByCoursId(coursId);
        if (devoirsForCoursId != null) {
            return devoirsForCoursId;
        }
        return null;
    }

    @Override
    public List<Devoir> getAllDevoirsForStudent(int userId) {
        /*TODO:in this function we need the cours microservice
        so that we can check all the cours that
        the user is subscribed to and then get all
        the devoirs that are in this cours and
        have not been completed by the user*/
        return null;
    }
}
