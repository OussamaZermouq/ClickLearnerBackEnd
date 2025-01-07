package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.model.Matier;

import java.util.List;

public interface IDocumentService {
    public Document getDocumentById(Long documentId);
    List<Document> getAllDocuments();
    void saveDocument(Document document);
    void updateDocument(Long documentId, Document document);
    void deleteDocument(Long documentId);

}
