package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class ExerciseDefaultRequest {
    String id;
    String exerciseName;
    String defaultSides;
    int defaultReps;
    int defaultSets;
    int defaultFrequency;
    double defaultMinAngle;
    double defaultMaxAngle;
    double defaultSensitivity;
    String bodyPart;
}
