package com.clicklearner.ms_cours.repository;

import com.clicklearner.ms_cours.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
