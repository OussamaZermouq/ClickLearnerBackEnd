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
    public Document saveDocument(String nomDocument, byte[] urlDocument, Long chapitreId) {

        Chapitre chapitre = chapitreRepository.findById(chapitreId)
                .orElseThrow(() -> new RuntimeException("Chapitre not found with ID: " + chapitreId));  // Lancer une exception si le chapitre n'existe pas

        Document document = Document.builder()
                .nomDocument(nomDocument)
                .urlDocument(urlDocument)
                .chapitres(chapitre)
                .build();

        Document savedDocument = documentRepository.save(document);

        return savedDocument;
    }

    @Override
    public byte[] getDocumentContentById(Long documentId) {
        Document document = documentRepository.findById(documentId).orElse(null);
        return (document != null) ? document.getUrlDocument() : null;
    }

    @Override
    public Document updateDocument(Long documentId, String nomDocument, byte[] urlDocument, Long chapitreId) {
        Document existingDocument = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + documentId));

        Chapitre chapitre = chapitreRepository.findById(chapitreId)
                .orElseThrow(() -> new RuntimeException("Chapitre not found with ID: " + chapitreId));

        existingDocument.setNomDocument(nomDocument);
        existingDocument.setUrlDocument(urlDocument);
        existingDocument.setChapitres(chapitre);

        return documentRepository.save(existingDocument);
    }

    @Override
    public void deleteDocument(Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + documentId));
        documentRepository.delete(document);
    }
}
