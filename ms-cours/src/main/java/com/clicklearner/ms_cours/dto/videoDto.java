package com.clicklearner.ms_cours.dto;

import com.clicklearner.ms_cours.model.Cours;
import lombok.*;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class videoDto {
    //private Long videoId;
    private String nomVideo;
    private String urlVideo;
    private Cours cours;

}
