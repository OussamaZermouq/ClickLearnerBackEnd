package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.repository.ChapitreRepository;
import com.clicklearner.ms_cours.repository.CoursRepository;
import com.clicklearner.ms_cours.service.interfaces.IChapitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapitreServiceImpt implements IChapitreService {

    @Autowired
    private ChapitreRepository chapitreRepository;
    @Autowired
    private  CoursRepository coursRepository;

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

    @Override
    public Chapitre addChapitre(Chapitre chapitre) {
        if (coursRepository.existsById(chapitre.getCours().getCoursId())) {
            return chapitreRepository.save(chapitre);
        }
        throw new IllegalArgumentException("Le cours associé n'existe pas.");
    }

    @Override
    public Chapitre updateChapitre(Long chapitreId, Chapitre updatedChapitre) {
        Optional<Chapitre> existingChapitre = chapitreRepository.findById(chapitreId);
        if (existingChapitre.isPresent() && coursRepository.existsById(updatedChapitre.getCours().getCoursId())) {
            Chapitre chapitre = existingChapitre.get();
            chapitre.setTitreChapitre(updatedChapitre.getTitreChapitre());
            chapitre.setNumChapitre(updatedChapitre.getNumChapitre());
            chapitre.setCours(updatedChapitre.getCours());
            return chapitreRepository.save(chapitre);
        }
        throw new IllegalArgumentException("Chapitre ou cours associé non valide.");
    }

    @Override
    public void deleteChapitre(Long chapitreId) {
        if (chapitreRepository.existsById(chapitreId)) {
            chapitreRepository.deleteById(chapitreId);
        }
    }
}
