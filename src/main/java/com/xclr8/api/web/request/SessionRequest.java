package com.xclr8.api.web.request;

import com.xclr8.api.nestedModel.Exercise;
import com.xclr8.api.nestedModel.Summary;
import lombok.Data;

import java.util.List;

@Data
public class SessionRequest {
    String patientId;
    String therapistId;
    String timestamp;
    String sessionGroupId;
    Summary sessionSummary;
    List<Exercise> exercises;
    String replayPath;
    String notes;
}
