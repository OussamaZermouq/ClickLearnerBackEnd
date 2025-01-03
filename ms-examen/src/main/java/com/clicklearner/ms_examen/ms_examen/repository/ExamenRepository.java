package com.clicklearner.ms_examen.ms_examen.repository;

import com.clicklearner.ms_examen.ms_examen.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {

    public Optional<List<Examen>> getExamenByCoursId(int coursId);
}
