package com.clicklearner.ms_devoir.service.interfaces;

import com.clicklearner.ms_devoir.model.question.Choix;
import org.springframework.stereotype.Service;

@Service
public interface IChoixService {
    public void addChoix(Choix choix);
    public Choix getChoixById(int choixId);
    public void deleteChoix(int choixId);

}
