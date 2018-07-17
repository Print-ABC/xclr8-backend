package com.xclr8.api.model;

import com.xclr8.api.model.nestedModel.Note;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Diagnosis")
public class Diagnosis {
    @Id
    String id;

    @Field
    String patientId;

    @Field
    String subjective;

    @Field
    String objective;

    @Field
    String assessment;

    @Field
    String plan;

    @Field
    String diagnosisDate;

    @Field
    //0 = archived, 1 = active
    int status;

    @Field
    List<Note> notes;

    @Field
    double complianceThreshold;
}
