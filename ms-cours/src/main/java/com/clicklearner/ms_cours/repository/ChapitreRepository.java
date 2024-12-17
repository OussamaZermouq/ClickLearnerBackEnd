package com.clicklearner.ms_cours.repository;

import com.clicklearner.ms_cours.model.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {
}
