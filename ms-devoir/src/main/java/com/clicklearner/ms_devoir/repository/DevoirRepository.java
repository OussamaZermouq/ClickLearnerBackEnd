package com.clicklearner.ms_devoir.repository;

import com.clicklearner.ms_devoir.model.Devoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevoirRepository extends JpaRepository<Devoir, Integer> {
    List<Devoir> getDevoirByCoursId(int coursId);
}
