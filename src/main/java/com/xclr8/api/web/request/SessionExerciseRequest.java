package com.xclr8.api.web.request;

import com.xclr8.api.model.nestedModel.Exercise;
import lombok.Data;

import java.util.List;

@Data
public class SessionExerciseRequest {
    String id;
    List<Exercise> exercises;
}
