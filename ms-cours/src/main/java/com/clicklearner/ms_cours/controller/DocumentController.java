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

    // Dossier où les fichiers peuvent être enregistrés temporairement
    private static final String FILE_DIRECTORY = "C:/Users/Admin/Desktop/URL_Java/documments";

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        // Retourne la liste de tous les documents
        return documentService.getAllDocuments();
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> displayDocument(@PathVariable Long id) {
        // Récupère le contenu du document par son ID
        byte[] content = documentService.getDocumentContentById(id);
        if (content == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Retourne 404 si le document n'est pas trouvé
        }

        // Configure les en-têtes de la réponse pour indiquer qu'il s'agit d'un fichier à afficher inline
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);  // Définir le type de contenu comme PDF
        headers.setContentDisposition(ContentDisposition.builder("inline")  // Indique que le fichier doit être affiché dans le navigateur
                .filename("document_" + id + ".pdf")
                .build());

        return ResponseEntity.ok().headers(headers).body(content);  // Retourne le document avec les en-têtes appropriés
    }


    @PostMapping("/documents/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("nomDocument") String nomDocument,
                                                 @RequestParam("chapitreId") Long chapitreId) {
        try {
            // Vérification dans les logs pour s'assurer que les valeurs sont correctement reçues
            System.out.println("Nom du fichier : " + file.getOriginalFilename());
            System.out.println("Nom du document : " + nomDocument);
            System.out.println("Chapitre ID : " + chapitreId);

            // Récupère le contenu du fichier sous forme de tableau de bytes
            byte[] urlDocument = file.getBytes();

            // Appel du service pour enregistrer le document dans la base de données
            Document savedDocument = documentService.saveDocument(nomDocument, urlDocument, chapitreId);

            // Retourne une réponse OK si tout se passe bien
            return ResponseEntity.ok("Document uploaded successfully. Document ID: " + savedDocument.getDocumentId());
        } catch (Exception e) {
            e.printStackTrace();  // Affiche l'exception dans les logs pour le débogage
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload document.");
        }
    }

    // Route pour mettre à jour un document
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

    // Route pour supprimer un document
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
