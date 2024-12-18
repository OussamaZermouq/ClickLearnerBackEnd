package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.model.Video;
import com.clicklearner.ms_cours.repository.MatierRepository;
import com.clicklearner.ms_cours.repository.VideoRepository;
import com.clicklearner.ms_cours.service.interfaces.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpt implements IVideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video getVideoById(Long videoId) {
        Optional<Video> video = videoRepository.findById(videoId);
        if (video.isPresent()){
            return video.get();
        }
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
