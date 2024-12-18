package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.model.Matier;

import java.util.List;

public interface ICoursService {

    public Cours getCourById(Long coursId);
    List<Cours> getAllcours();
}
