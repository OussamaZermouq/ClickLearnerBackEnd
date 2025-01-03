package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Document;
import com.clicklearner.ms_cours.service.implementations.DocumentServiceImplt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class DocumentController {

    @Autowired
    DocumentServiceImplt documentService;

    //private static final String FILE_DIRECTORY = "C:/Users/Admin/Desktop/URL_Java/documments";

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> displayDocument(@PathVariable Long id) {
        byte[] content = documentService.getDocumentContentById(id);
        if (content == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline")
                .filename("document_" + id + ".pdf")
                .build());

        return ResponseEntity.ok().headers(headers).body(content);
    }


    @PostMapping("/documents/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("nomDocument") String nomDocument,
                                                 @RequestParam("chapitreId") Long chapitreId) {
        try {
            System.out.println("Nom du fichier : " + file.getOriginalFilename());
            System.out.println("Nom du document : " + nomDocument);
            System.out.println("Chapitre ID : " + chapitreId);

            byte[] urlDocument = file.getBytes();

            Document savedDocument = documentService.saveDocument(nomDocument, urlDocument, chapitreId);

            return ResponseEntity.ok("Document uploaded successfully. Document ID: " + savedDocument.getDocumentId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload document.");
        }
    }

    @PutMapping("/documents/update/{id}")
    public ResponseEntity<String> updateDocument(@PathVariable Long id,
                                                 @RequestParam("nomDocument") String nomDocument,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam("chapitreId") Long chapitreId) {
        try {
            byte[] urlDocument = file.getBytes();
            Document updatedDocument = documentService.updateDocument(id, nomDocument, urlDocument, chapitreId);

            return ResponseEntity.ok("Document updated successfully. Document ID: " + updatedDocument.getDocumentId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update document.");
        }
    }

    @DeleteMapping("/documents/delete/{id}")
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
