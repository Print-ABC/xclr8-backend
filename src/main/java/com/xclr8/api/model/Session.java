package com.xclr8.api.model;

import com.xclr8.api.model.nestedModel.Exercise;
import com.xclr8.api.model.nestedModel.Summary;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Session")
public class Session {
    @Id
    String id;

    @Field
    String patientId;

    @Field
    String therapistId;

    @Field
    String timestamp;

    @Field
    //Uses diagnosis ID to set session group, used to do bulk changes to rehab programs in one go
    String sessionGroupId;

    @Field
    Summary sessionSummary;

    @Field
    List<Exercise> exercises;

    @Field
    String replayPath;

    @Field
    //Only one editable note per session by therapists for sessions, unlike diagnosis where there can be many.
    String notes;
}
