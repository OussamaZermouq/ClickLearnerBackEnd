package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.dto.DocumentDto;
import com.clicklearner.ms_cours.dto.ResponseDto;
import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.service.implementations.DocumentServiceImplt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/ms-cours/api/v1/document")
public class DocumentController {

    @Autowired
    DocumentServiceImplt documentService;

    //private static final String FILE_DIRECTORY = "C:/Users/Admin/Desktop/URL_Java/documments";

    @GetMapping("/")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        if (document == null) {
            return ResponseEntity.ok().body(document);
        }
        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.NOT_FOUND, "Couldn't find document"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDocument(@PathVariable Long id,@RequestBody Document document) {
        try {

            documentService.updateDocument(id, document);

            return ResponseEntity.ok(new ResponseDto(HttpStatus.OK,"Document updated successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR,"ERROR"));

        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        try {
            documentService.deleteDocument(id);
            return ResponseEntity.ok("Document deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete document.");
        }
    }
}
