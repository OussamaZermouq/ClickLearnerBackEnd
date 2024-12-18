package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.repository.DocumentRepository;
import com.clicklearner.ms_cours.service.implementations.DocumentServiceImplt;
import com.clicklearner.ms_cours.service.implementations.MatierServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    DocumentServiceImplt documentService;

    private static final String FILE_DIRECTORY = "C:/Users/Admin/Desktop/URL_Java/documments";

    @GetMapping("/documents")
    public List<Document> getAllDocuments(){
        return documentService.getAllDocuments();
    }

    @GetMapping("/documents/{id}")
    public Document documentById(@PathVariable Long id){
        Document document = documentService.getDocumentById(id);

        return document;
    }
}
