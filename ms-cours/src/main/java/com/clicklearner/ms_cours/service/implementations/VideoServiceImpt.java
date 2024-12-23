package com.clicklearner.ms_cours.service.implementations;

import com.clicklearner.ms_cours.model.Video;
import com.clicklearner.ms_cours.model.Chapitre;
import com.clicklearner.ms_cours.repository.VideoRepository;
import com.clicklearner.ms_cours.repository.ChapitreRepository;  // Import du repository Chapitre
import com.clicklearner.ms_cours.service.interfaces.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpt implements IVideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private ChapitreRepository chapitreRepository;

    private static final String VIDEO_BASE_PATH = "C:/Users/Admin/Desktop/URL_Java/videos/";

    @Override
    public Video getVideoById(Long videoId) {
        return videoRepository.findById(videoId).orElse(null);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public boolean isVideoValid(String videoPath) {
        return Files.exists(Paths.get(VIDEO_BASE_PATH + videoPath));
    }

    @Override
    public Video addVideo(Video video) {
        if (video.getChapitres() != null && chapitreExists(video.getChapitres().getChapitreId())) {
            return videoRepository.save(video);
        } else {
            return null;
        }
    }

    @Override
    public Video updateVideo(Long videoId, Video updatedVideo) {
        Optional<Video> existingVideo = videoRepository.findById(videoId);
        if (existingVideo.isPresent()) {
            Video video = existingVideo.get();
            video.setNomVideo(updatedVideo.getNomVideo());
            video.setUrlVideo(updatedVideo.getUrlVideo());
            return videoRepository.save(video);
        }
        return null;
    }

    @Override
    public void deleteVideo(Long videoId) {
        videoRepository.deleteById(videoId);
    }

    @Override
    public boolean chapitreExists(Long chapitreId) {
        return chapitreRepository.existsById(chapitreId);
    }
}
