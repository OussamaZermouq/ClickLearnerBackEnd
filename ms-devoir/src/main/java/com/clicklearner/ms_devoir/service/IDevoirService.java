package com.clicklearner.ms_devoir.service;


import com.clicklearner.ms_devoir.model.Devoir;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDevoirService {
    public void addDevoir(Devoir devoir, int courseId);
    public void updateDevoir(Devoir devoir, int devoirId);
    public Devoir getDevoirById(int devoirId);
    public List<Devoir> getAllDevoirs();
    public List<Devoir> getDevoirForCourse(int courseId);
}
