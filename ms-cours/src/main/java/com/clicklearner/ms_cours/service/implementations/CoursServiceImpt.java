package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.CoursRepository;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.interfaces.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursServiceImpt implements ICoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private MatierRepository matierRepository;

    @Override
    public Cours getCourById(Long coursId) {
        Optional<Cours> cours = coursRepository.findById(coursId);
        if (cours.isPresent()){
            return cours.get();
        }
        return null;
    }

    @Override
    public List<Cours> getAllcours() {

        return coursRepository.findAll();
    }

    @Override
    public Cours addCour(Cours cours) {
        if (matierRepository.existsById(cours.getMatier().getMatierId())) {
            return coursRepository.save(cours);
        }
        throw new IllegalArgumentException("Le cours associé n'existe pas.");
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
