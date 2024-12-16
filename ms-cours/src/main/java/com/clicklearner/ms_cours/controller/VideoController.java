package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Video;
import com.clicklearner.ms_cours.repository.VideoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    private VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/videos")
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @GetMapping("/videos/{id}")
    public Video videoById(@PathVariable Long id){
        return videoRepository.findById(id).get();
    }
}
