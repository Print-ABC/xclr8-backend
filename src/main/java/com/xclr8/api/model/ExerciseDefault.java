package com.xclr8.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document(collection = "Exercise_default")
public class ExerciseDefault {
    @Id
    String id;

    @Field
    String exerciseName;

    @Field
    //Left side, right side
    String defaultSides;

    @Field
    int defaultReps;

    @Field
    int defaultSets;

    @Field
    int defaultFrequency;

    @Field
    double defaultMinAngle;

    @Field
    double defaultMaxAngle;

    @Field
    double defaultSensitivity;

    @Field
    String bodyPart;

//    Maybe in the future the defaults could be stored offline
//    @Field
//    String checksum;
}
