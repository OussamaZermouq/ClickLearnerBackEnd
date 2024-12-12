package com.clicklearner.ms_devoir.repository;

import com.clicklearner.ms_devoir.model.Devoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevoirRepository extends JpaRepository<Devoir, Integer> {
}
