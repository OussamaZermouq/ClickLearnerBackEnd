package com.clicklearner.msprogression.service.implementations;

import com.clicklearner.msprogression.dto.CoursDto;
import com.clicklearner.msprogression.dto.ProgressionDto;
import com.clicklearner.msprogression.dto.UserDto;
import com.clicklearner.msprogression.model.Progression;
import com.clicklearner.msprogression.openfeign.CoursServiceClient;
import com.clicklearner.msprogression.openfeign.UserServiceClient;
import com.clicklearner.msprogression.repository.ProgressionRepository;
import com.clicklearner.msprogression.service.interfaces.IProgressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressionServiceImpl implements IProgressionService {
    @Autowired
    private ProgressionRepository progressionRepository;
    @Autowired
    private CoursServiceClient coursServiceClient;
    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public ProgressionDto getProgressionByCoursIdAndUserId(int coursId, int userId) {
        Progression progression = progressionRepository.findProgressionByCoursIdAndEtudiantId(coursId, userId);
        Optional<CoursDto> coursDtoOptional = coursServiceClient.getCoursById(coursId);
        Optional<UserDto> userDtoOptional = userServiceClient.getUserById(userId);

        if (progression!=null && coursDtoOptional.isPresent() && userDtoOptional.isPresent()){
            ProgressionDto progressionDto = ProgressionDto.builder().
                    progressionId(progression.getProgressionId()).
                    progression(progression.getPourcentage()).
                    studentDto(userDtoOptional.get()).
                    coursDto(coursDtoOptional.get()).
                    build();
            return progressionDto;

        }
        return null;
    }
    @Override
    public void updateProgression(Progression progression) {
        progressionRepository.save(progression);
    }

    @Override
    public Progression createProgression(Progression progression) {
        return progressionRepository.save(progression);
    }
}
