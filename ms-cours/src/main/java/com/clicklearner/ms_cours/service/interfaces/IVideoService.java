package com.clicklearner.ms_cours.service.interfaces;

import com.clicklearner.ms_cours.model.Matier;
import com.clicklearner.ms_cours.model.Video;

import java.util.List;

public interface IVideoService {
    public Video getVideoById(Long videoId);
    List<Video> getAllVideos();
}
