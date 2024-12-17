package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.dto.MatierDto;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.interfaces.IMatierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatierServiceImpt implements IMatierService {

    @Autowired
    private MatierRepository matierRepository;
    @Override
    public Matier getMatierById(Long matierId) {
        Optional<Matier> matier = matierRepository.findById(matierId);
        if (matier.isPresent()){
            return matier.get();
        }
        return null;
    }

    @Override
    public List<Matier> getAllMatiers() {
        return matierRepository.findAll();
    }
}
