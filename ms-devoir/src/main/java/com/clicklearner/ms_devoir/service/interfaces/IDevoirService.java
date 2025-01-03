package com.clicklearner.ms_devoir.service.interfaces;


import com.clicklearner.ms_devoir.DTO.DevoirDTO;
import com.clicklearner.ms_devoir.model.Devoir;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDevoirService {
    public void addDevoir(Devoir devoir);
    public void updateDevoir(Devoir devoir, int devoirId);
    public DevoirDTO getDevoirById(int devoirId);
    public List<Devoir> getAllDevoirs();
    public List<Devoir> getDevoirForCourse(int courseId);
    public void deleteDevoir(int devoirId);

    public List<Devoir> getDevoirbyCoursId(int coursId);

    List<Devoir> getAllDevoirsForStudent(int  userId);
}
