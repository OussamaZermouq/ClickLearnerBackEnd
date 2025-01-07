package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.repository.ChapitreRepository;
import com.clicklearner.ms_cours.repository.DocumentRepository;
import com.clicklearner.ms_cours.service.interfaces.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImplt implements IDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ChapitreRepository chapitreRepository;


    @Override
    public Document getDocumentById(Long documentId) {
        Optional<Document> document = documentRepository.findById(documentId);
        return document.orElse(null);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }



    @Override
    public void updateDocument(Long documentId, Document document) {
        if (documentRepository.findById(documentId)!=null){
            documentRepository.save(document);
        }
    }

    @Override
    public void deleteDocument(Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + documentId));
        documentRepository.delete(document);
    }
}
