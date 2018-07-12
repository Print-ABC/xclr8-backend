package com.xclr8.api.web.request;

import com.xclr8.api.model.nestedModel.Exercise;
import com.xclr8.api.model.nestedModel.Summary;
import lombok.Data;

import java.util.List;

@Data
public class SessionRequest {
    String id;
    String patientId;
    String therapistId;
    String timestamp;
    String sessionGroupId;
    Summary sessionSummary;
    List<Exercise> exercises;
    String replayPath;
    String notes;
}
