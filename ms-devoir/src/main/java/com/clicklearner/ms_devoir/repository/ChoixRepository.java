package com.clicklearner.ms_devoir.repository;

import com.clicklearner.ms_devoir.model.Choix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoixRepository extends JpaRepository<Choix, Integer> {
}
