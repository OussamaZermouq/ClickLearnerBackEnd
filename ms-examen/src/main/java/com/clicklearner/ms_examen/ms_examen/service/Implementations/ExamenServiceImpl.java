package com.clicklearner.ms_examen.ms_examen.service.Implementations;

import com.clicklearner.ms_examen.ms_examen.model.Examen;
import com.clicklearner.ms_examen.ms_examen.repository.ExamenRepository;
import com.clicklearner.ms_examen.ms_examen.service.interfaces.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements IExamenService {

    @Autowired
    public ExamenRepository examenRepository;
    @Override
    public void createExamen(Examen examen) {
        examenRepository.save(examen);
    }

    @Override
    public Examen getExamenById(int examenId) {
        Optional<Examen> examen = examenRepository.findById(examenId);
        if (examen.isPresent()){
            return examen.get();
        }
        return null;
    }

    @Override
    public List<Examen> getExamenForCours(int coursId) {
        Optional<List<Examen>> examenList = examenRepository.getExamenByCoursId(coursId);
        if (examenList.isPresent()) {
            return examenList.get();
        }
        return null;
    }
}
