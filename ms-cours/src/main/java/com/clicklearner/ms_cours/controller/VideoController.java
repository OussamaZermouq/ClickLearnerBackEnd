package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Video;
import com.clicklearner.ms_cours.service.implementations.VideoServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private VideoServiceImpt videoService;

    private static final String VIDEO_BASE_PATH = "C:/Users/Admin/Desktop/URL_Java/videos/";

    @GetMapping("/videos")
    public List<Video> videoList() {
        List<Video> videos = videoService.getAllVideos();
        videos.forEach(video -> video.setUrlVideo(VIDEO_BASE_PATH + video.getUrlVideo()));
        return videos;
    }

    @GetMapping("/videos/{id}")
    public Video videoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }


    @PostMapping("/videos/upload")
    public ResponseEntity<String> addVideo(@RequestBody Video video) {

        if (videoService.isVideoValid(video.getUrlVideo()) && video.getChapitres() != null
                && video.getChapitres().getChapitreId() != null) {
            if (videoService.chapitreExists(video.getChapitres().getChapitreId())) {
                videoService.addVideo(video);
                return ResponseEntity.ok("Vidéo ajoutée avec succès !");
            } else {
                return ResponseEntity.badRequest().body("Le chapitre spécifié n'existe pas !");
            }
        } else {
            return ResponseEntity.badRequest().body("Le fichier vidéo n'existe pas ou les données sont invalides !");
        }
    }


    @PutMapping("/videos/update/{id}")
    public ResponseEntity<String> updateVideo(@PathVariable Long id, @RequestBody Video updatedVideo) {
        Video video = videoService.updateVideo(id, updatedVideo);
        if (video != null) {
            return ResponseEntity.ok("Vidéo mise à jour avec succès !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/videos/delete/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.ok("Vidéo supprimée avec succès !");
    }


    @GetMapping("/videos/play/{id}")
    public ResponseEntity<Resource> playVideo(@PathVariable Long id) {
        Video video = videoService.getVideoById(id);

        if (video == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            Path filePath = Paths.get(VIDEO_BASE_PATH + video.getUrlVideo());
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
