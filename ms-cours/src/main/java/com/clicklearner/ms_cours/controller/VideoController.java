package com.clicklearner.ms_cours.controller;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.model.Video;
import com.clicklearner.ms_cours.repository.VideoRepository;
import com.clicklearner.ms_cours.service.implementations.VideoServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoServiceImpt videoService;



    @GetMapping("/videos")
    public List<Video> videoList(){
        return videoService.getAllVideos();
    }

    @GetMapping("/videos/{id}")
    public Video videoById(@PathVariable Long id){
        Video video = videoService.getVideoById(id);

        return video;
    }
}
