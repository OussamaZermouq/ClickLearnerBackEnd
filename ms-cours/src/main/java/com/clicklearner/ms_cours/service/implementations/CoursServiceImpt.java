package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.dto.CoursDto;
import com.clicklearner.ms_cours.dto.user.ProfDto;
import com.clicklearner.ms_cours.dto.user.UserDto;
import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.openfeign.UserServiceClient;
import com.clicklearner.ms_cours.repository.CoursRepository;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.interfaces.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class CoursServiceImpt implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private UserServiceClient userServiceClient;
    @Override
    public CoursDto getCourById(Long coursId) {
        Optional<Cours> coursOptional = coursRepository.findById(coursId);
        if (coursOptional.isPresent()){
            Cours cours = coursOptional.get();
            Optional<ProfDto> profDto = userServiceClient.getUserById(cours.getProfId());
            if (profDto.isPresent()){
                CoursDto coursDto = CoursDto.builder().
                        coursId(cours.getCoursId()).
                        titreCours(cours.getTitreCours()).
                        coursImage(cours.getCoursImage()).
                        descriptionCours(cours.getDescriptionCours()).
                        prof(profDto.get()).
                        difficulty(cours.getDifficulty()).
                        estimatedDuration(cours.getEstimatedDuration()).
                        matier(cours.getMatier()).
                        chapitres(cours.getChapitres()).
                        build();
                return coursDto;
            }
        }
        return null;
    }

    @Override
    public List<Cours> getAllcours() {

        return coursRepository.findAll();
    }



    @Override
    public void addCour(Cours cours) {
        coursRepository.save(cours);
    }

    @Override
    public Cours updateCour(Long coursId, Cours cours) {
        Optional<Cours> existingCours = coursRepository.findById(coursId);
        if (existingCours.isEmpty()) {
            throw new IllegalArgumentException("Le cours à mettre à jour n'existe pas.");
        }
        cours.setCoursId(coursId);
        return coursRepository.save(cours);
    }

    @Override
    public void deleteCour(Long coursId) {
        if (!coursRepository.existsById(coursId)) {
            throw new IllegalArgumentException("Le cours à supprimer n'existe pas.");
        }
        coursRepository.deleteById(coursId);
    }
}
