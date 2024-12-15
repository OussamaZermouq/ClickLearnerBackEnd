package com.clicklearner.ms_cours.repository;

import com.clicklearner.ms_cours.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VideoRepository extends JpaRepository<Video, Long> {
}
