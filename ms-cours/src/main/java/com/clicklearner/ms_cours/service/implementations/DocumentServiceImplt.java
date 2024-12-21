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
        return document.orElse(null);  // Retourne le document s'il existe, sinon null
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();  // Récupère tous les documents
    }

    @Override
    public Document saveDocument(String nomDocument, byte[] urlDocument, Long chapitreId) {
        // Valider l'existence du chapitre dans la base de données
        Chapitre chapitre = chapitreRepository.findById(chapitreId)
                .orElseThrow(() -> new RuntimeException("Chapitre not found with ID: " + chapitreId));  // Lancer une exception si le chapitre n'existe pas

        // Créer un nouvel objet Document
        Document document = Document.builder()
                .nomDocument(nomDocument)
                .urlDocument(urlDocument)
                .chapitres(chapitre)  // Associer le chapitre trouvé
                .build();

        // Sauvegarder le document dans la base de données
        Document savedDocument = documentRepository.save(document);

        return savedDocument;  // Retourner le document enregistré avec l'ID généré
    }

    @Override
    public byte[] getDocumentContentById(Long documentId) {
        Document document = documentRepository.findById(documentId).orElse(null);
        return (document != null) ? document.getUrlDocument() : null;  // Retourne le contenu du document ou null si pas trouvé
    }

    // Méthode de mise à jour d'un document
    @Override
    public Document updateDocument(Long documentId, String nomDocument, byte[] urlDocument, Long chapitreId) {
        Document existingDocument = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + documentId));

        Chapitre chapitre = chapitreRepository.findById(chapitreId)
                .orElseThrow(() -> new RuntimeException("Chapitre not found with ID: " + chapitreId));

        // Mettre à jour les informations du document
        existingDocument.setNomDocument(nomDocument);
        existingDocument.setUrlDocument(urlDocument);
        existingDocument.setChapitres(chapitre);

        return documentRepository.save(existingDocument);
    }

    // Méthode de suppression d'un document
    @Override
    public void deleteDocument(Long documentId) {
        Document document = documentRepository.findById(documentId)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + documentId));
        documentRepository.delete(document);
    }
}
