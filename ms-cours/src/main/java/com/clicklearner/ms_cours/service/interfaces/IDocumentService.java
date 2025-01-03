package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.model.Matier;

import java.util.List;

public interface IDocumentService {
    public Document getDocumentById(Long documentId);
    List<Document> getAllDocuments();
    Document saveDocument(String nomDocument, byte[] urlDocument, Long chapitreId);
    byte[] getDocumentContentById(Long documentId);
    Document updateDocument(Long documentId, String nomDocument, byte[] urlDocument, Long chapitreId);
    void deleteDocument(Long documentId);

}
