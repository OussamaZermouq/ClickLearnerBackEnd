package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.model.Video;

import java.util.List;

public interface IVideoService {
    Video getVideoById(Long videoId);
    List<Video> getAllVideos();
    boolean isVideoValid(String videoPath);
    Video addVideo(Video video);
    Video updateVideo(Long videoId, Video updatedVideo);
    void deleteVideo(Long videoId);
    boolean chapitreExists(Long chapitreId);
}
