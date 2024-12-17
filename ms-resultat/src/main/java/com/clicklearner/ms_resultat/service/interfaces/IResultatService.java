package com.clicklearner.ms_resultat.service.interfaces;


import com.clicklearner.ms_resultat.Dto.ResponseDto;
import com.clicklearner.ms_resultat.model.Resultat;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IResultatService {
    public void ajouterResultat(Resultat resultat);
    public Resultat getResultatById(int resultatId);
    //for the profs
    public List<Resultat> getResultatsByDevoirId(int devoirId);
    //for the students
    public Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId);


    public Resultat calculateGradeForDevoir(int devoirId);
}
