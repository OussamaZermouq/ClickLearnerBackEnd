package com.clicklearner.ms_resultat.service.interfaces;


import com.clicklearner.ms_resultat.Dto.DevoirResultsDto;
import com.clicklearner.ms_resultat.model.Resultat;
import com.clicklearner.ms_resultat.model.ResultatDevoir;


import java.util.List;

public interface IResultatService {
    public void ajouterResultat(Resultat resultat);
    public Resultat getResultatById(int resultatId);
    //for the profs
    public List<ResultatDevoir> getResultatsByDevoirId(int devoirId);
    //for the students
    public Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId);


    public DevoirResultsDto calculateGradeForDevoir(int devoirId, int userId);
}
