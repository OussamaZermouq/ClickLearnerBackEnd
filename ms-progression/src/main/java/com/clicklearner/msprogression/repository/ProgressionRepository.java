package com.clicklearner.msprogression.repository;

import com.clicklearner.msprogression.model.Progression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressionRepository extends JpaRepository<Progression, Long> {

    Progression findProgressionByCoursIdAndEtudiantId(int coursId, int etudiantId);
}
