package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.dto.CoursDto;
import com.clicklearner.ms_cours.model.Cours;
import com.clicklearner.ms_cours.model.Matier;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICoursService {

    CoursDto getCourById(Long coursId);
    List<Cours> getAllcours();
    void addCour(Cours cours) ;
    Cours updateCour(Long coursId, Cours cours);
    void deleteCour(Long coursId);
}
