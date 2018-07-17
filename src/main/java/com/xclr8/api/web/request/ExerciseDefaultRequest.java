package com.xclr8.api.web.request;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseDefaultRequest {
    String id;
    String exerciseName;
    int defaultReps;
    int defaultSets;
    int defaultFrequency;
    double defaultMinAngle;
    double defaultMaxAngle;
    double defaultSensitivity;
    List<String> bodyPart;
}
