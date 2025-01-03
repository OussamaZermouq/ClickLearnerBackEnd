package com.clicklearner.ms_examen.ms_examen.service.interfaces;

import com.clicklearner.ms_examen.ms_examen.model.Examen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExamenService {
    public void createExamen(Examen examen);
    public Examen getExamenById(int examenId);
    public List<Examen> getExamenForCours(int coursId);

}
