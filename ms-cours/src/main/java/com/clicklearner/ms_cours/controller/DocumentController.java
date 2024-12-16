package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.repository.DocumentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentController {
    private DocumentRepository documentRepository;

    public DocumentController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/documents")
    public List<Document> documentList(){
        return documentRepository.findAll();
    }

    @GetMapping("/documents/{id}")
    public Document documentById(@PathVariable Long id){
        return documentRepository.findById(id).get();
    }
}
