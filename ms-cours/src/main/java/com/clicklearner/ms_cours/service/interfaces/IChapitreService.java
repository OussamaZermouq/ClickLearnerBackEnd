package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Matier;

import java.util.List;

public interface IChapitreService {

    public Chapitre getChapitreById(Long chapitreId);
    List<Chapitre> getAllChapitres();
    Chapitre addChapitre(Chapitre chapitre);
    Chapitre updateChapitre(Long chapitreId, Chapitre updatedChapitre);
    void deleteChapitre(Long chapitreId);
}
