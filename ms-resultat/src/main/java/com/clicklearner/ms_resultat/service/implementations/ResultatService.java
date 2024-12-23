package com.clicklearner.ms_resultat.service.implementations;

import com.clicklearner.ms_resultat.Dto.*;
import com.clicklearner.ms_resultat.model.Resultat;
import com.clicklearner.ms_resultat.model.ResultatDevoir;
import com.clicklearner.ms_resultat.openfiegn.DevoirServiceClient;
import com.clicklearner.ms_resultat.openfiegn.UserServiceClient;
import com.clicklearner.ms_resultat.repository.ResultatRepository;
import com.clicklearner.ms_resultat.service.interfaces.IResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultatService implements IResultatService {
    @Autowired
    public ResultatRepository resultatRepository;
    @Autowired
    public DevoirServiceClient devoirServiceClient;
    @Autowired
    public UserServiceClient userServiceClient;


    @Override
    public void ajouterResultat(Resultat resultat) {
        resultatRepository.save(resultat);
    }

    @Override
    public Resultat getResultatById(int resultatId) {
        Optional<Resultat> resultat = resultatRepository.findById(resultatId);
        if (resultat.isPresent()){
            return resultat.get();
        }
        return null;
    }

    @Override
    public List<ResultatDevoir> getResultatsByDevoirId(int devoirId) {
        List<ResultatDevoir> resultatByDevoirId = resultatRepository.getResultatByDevoirId(devoirId);
        if (resultatByDevoirId!=null){
            return resultatByDevoirId;
        }
        return null;
    }
    @Override
    public Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId) {
        Resultat resultatByStudentIdAndDevoirId = resultatRepository.getResultatByStudentIdAndByDevoirId(devoirId, studentId);
        if (resultatByStudentIdAndDevoirId!=null){
            return resultatByStudentIdAndDevoirId;
        }
        return null;
    }

    /*
    * 1 get the user response for this devoir using the devoirId
    * 2 compare the inputs with the correct answer
    * 3 calculate grade
    * */
    @Override
    public DevoirResultsDto calculateGradeForDevoir(int devoirId, int userId) {

        Optional<List<UserResponseDto>> userResponsesDtoOptional = devoirServiceClient.getUserSubmissionForDevoirByDevoirId(userId, devoirId);
        DevoirResultsDto devoirResultsDto = new DevoirResultsDto();
        if (userResponsesDtoOptional.isPresent()){
            devoirResultsDto.setDevoirId(devoirId);


            for (UserResponseDto userResponseDto: userResponsesDtoOptional.get()){
                if (userResponseDto.getQuestion() instanceof MultipleChoiceQuestionDto){
                    MultipleChoiceQuestionDto multipleChoiceQuestionDto = (MultipleChoiceQuestionDto) userResponseDto.getQuestion();
                    if (((MultipleChoiceQuestionDto) userResponseDto.getQuestion()).getCorrectAnswer().getChoixId() == multipleChoiceQuestionDto.getCorrectAnswer().getChoixId()){
                        devoirResultsDto.getUserDevoirPointDtos().add(new UserQuestionPointDto(userResponseDto.getQuestion().getQuestionId(), userId, 1));
                    }
                    else {
                        devoirResultsDto.getUserDevoirPointDtos().add(new UserQuestionPointDto(multipleChoiceQuestionDto.getQuestionId(), userId, 0));
                    }
                }
            }
            return devoirResultsDto;
        }
        return null;
    }
}
