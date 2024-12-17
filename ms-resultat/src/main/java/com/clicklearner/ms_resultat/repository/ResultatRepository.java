package com.clicklearner.ms_resultat.repository;

import com.clicklearner.ms_resultat.model.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Integer> {

    @Query("select Resultat from Resultat where ResultatDevoir.devoirId = ?1")
    public List<Resultat> getResultatByDevoirId(int devoirId);

    @Query("select ResultatDevoir from ResultatDevoir where ResultatDevoir.devoirId =?1 and ResultatDevoir.studentId=?2")
    Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId);

}
