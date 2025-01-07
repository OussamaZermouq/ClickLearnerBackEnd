package com.clicklearner.msprogression.service.interfaces;

import com.clicklearner.msprogression.dto.ProgressionDto;
import com.clicklearner.msprogression.model.Progression;

public interface IProgressionService {
    ProgressionDto getProgressionByCoursIdAndUserId(int coursId, int userId);
    void updateProgression(Progression progression);
    Progression createProgression(Progression progression);
}
