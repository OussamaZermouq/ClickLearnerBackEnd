package com.clicklearner.ms_resultat.service.implementations;

import com.clicklearner.ms_resultat.Dto.ResponseDto;
import com.clicklearner.ms_resultat.model.Resultat;
import com.clicklearner.ms_resultat.repository.ResultatRepository;
import com.clicklearner.ms_resultat.service.interfaces.IResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultatService implements IResultatService {
    @Autowired
    public ResultatRepository resultatRepository;
    @Override
    public void ajouterResultat(Resultat resultat) {
        resultatRepository.save(resultat);
    }

    @Override
    public Resultat getResultatById(int resultatId) {
        Optional<Resultat> resultat = resultatRepository.findById(resultatId);
        if (resultat.isPresent()){
            return resultat.get();
        }
        return null;
    }

    @Override
    public List<Resultat> getResultatsByDevoirId(int devoirId) {
        List<Resultat> resultatByDevoirId = resultatRepository.getResultatByDevoirId(devoirId);
        if (resultatByDevoirId!=null){
            return resultatByDevoirId;
        }
        return null;
    }
    @Override
    public Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId) {
        Resultat resultatByStudentIdAndDevoirId = resultatRepository.getResultatByStudentIdAndByDevoirId(devoirId, studentId);
        if (resultatByStudentIdAndDevoirId!=null){
            return resultatByStudentIdAndDevoirId;
        }
        return null;
    }

    @Override
    public Resultat calculateGradeForDevoir(int devoirId) {
        return null;
    }
}
