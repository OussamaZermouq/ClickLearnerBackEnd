package com.clicklearner.ms_resultat.repository;

import com.clicklearner.ms_resultat.model.Resultat;
import com.clicklearner.ms_resultat.model.ResultatDevoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Integer> {

    @Query("SELECT r FROM ResultatDevoir r where r.devoirId=?1")
    List<ResultatDevoir> getResultatByDevoirId(int devoirId);

    @Query(value = "select r from ResultatDevoir r where r.devoirId =?1 and r.studentId=?2")
    Resultat getResultatByStudentIdAndByDevoirId(int devoirId, int studentId);

}
