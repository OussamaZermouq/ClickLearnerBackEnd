package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.ChapitreRepository;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.interfaces.IChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapitreServiceImpt implements IChapitreService {

    @Autowired
    private ChapitreRepository chapitreRepository;

    @Override
    public Chapitre getChapitreById(Long chapitreId) {
        Optional<Chapitre> chapitre = chapitreRepository.findById(chapitreId);
        if (chapitre.isPresent()){
            return chapitre.get();
        }
        return null;
    }

    @Override
    public List<Chapitre> getAllChapitres() {
        return chapitreRepository.findAll();
    }
}
