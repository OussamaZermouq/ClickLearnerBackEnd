package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.DocumentRepository;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.service.interfaces.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImplt implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document getDocumentById(Long documentId) {
        Optional<Document> document = documentRepository.findById(documentId);
        if (document.isPresent()){
            return document.get();
        }
        return null;
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }


}
