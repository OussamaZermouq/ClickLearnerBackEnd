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
}
