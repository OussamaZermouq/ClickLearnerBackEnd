package com.clicklearner.ms_cours.service.interfaces;


import com.clicklearner.ms_cours.model.Matier;

import java.util.List;


public interface IMatierService {
    public Matier getMatierById(Long matierId);
    List<Matier> getAllMatiers();
    Matier addMatier(Matier matier);
    Matier updateMatier(Long matierId, Matier matier);
    void deleteMatier(Long matierId);


}
