package com.clicklearner.ms_devoir.service;

import com.clicklearner.ms_devoir.model.Devoir;
import com.clicklearner.ms_devoir.repository.DevoirRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DevoirService implements IDevoirService{
    @Autowired
    public DevoirRepository devoirRepository;

    @Override
    public void addDevoir(Devoir devoir, int courseId) {

    }

    @Override
    public void updateDevoir(Devoir devoir, int devoirId) {
        Optional<Devoir> devoirToUpdate = devoirRepository.findById(devoirId);
        if (devoirToUpdate.isPresent()){
            devoirRepository.save(devoirToUpdate.get());
        }
    }

    @Override
    public Devoir getDevoirById(int devoirId) {
        Optional<Devoir> devoir = devoirRepository.findById(devoirId);
        if(devoir.isPresent()){
            return devoir.get();
        }
        return null;
    }

    @Override
    public List<Devoir> getAllDevoirs() {
        List<Devoir> devoirs = devoirRepository.findAll();
        return devoirs;
    }

    @Override
    public List<Devoir> getDevoirForCourse(int courseId) {
        return null;
    }
}
