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

    @Override
    public Matier addMatier(Matier matier) {
        if (matierRepository.existsByNomMatier(matier.getNomMatier())) {
            throw new IllegalArgumentException("Cette matière existe déjà.");
        }
        return matierRepository.save(matier);
    }

    @Override
    public Matier updateMatier(Long matierId, Matier matier) {
        Optional<Matier> existingMatier = matierRepository.findById(matierId);
        if (matierRepository.existsByNomMatier(matier.getNomMatier())) {
            throw new IllegalArgumentException("Cette matière existe déjà.");
        }
        if (existingMatier.isEmpty()) {
            throw new IllegalArgumentException("La matière à mettre à jour n'existe pas.");
        }
        matier.setMatierId(matierId);
        return matierRepository.save(matier);
    }

    @Override
    public void deleteMatier(Long matierId) {
        if (!matierRepository.existsById(matierId)) {
            throw new IllegalArgumentException("La matière à supprimer n'existe pas.");
        }
        matierRepository.deleteById(matierId);
    }
}

