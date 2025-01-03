package com.clicklearner.ms_devoir.service.implementations;

import com.clicklearner.ms_devoir.model.question.Choix;
import com.clicklearner.ms_devoir.repository.ChoixRepository;
import com.clicklearner.ms_devoir.service.interfaces.IChoixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChoixServiceImpl implements IChoixService {
    @Autowired
    private ChoixRepository choixRepository;
    @Override
    public void addChoix(Choix choix) {
        choixRepository.save(choix);
    }

    @Override
    public Choix getChoixById(int choixId) {
        Optional<Choix> choix = choixRepository.findById(choixId);
        if (choix.isPresent()){
            return choix.get();
        }
        return null;
    }

    @Override
    public void deleteChoix(int choixId) {
        Optional<Choix> choix = choixRepository.findById(choixId);
        if(choix.isPresent()){
            choixRepository.delete(choix.get());
        }
    }
}
