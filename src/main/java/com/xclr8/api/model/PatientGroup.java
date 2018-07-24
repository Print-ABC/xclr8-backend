package com.xclr8.api.model;

import com.xclr8.api.model.nestedModel.PatientGroupPatient;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Patient_group")
public class PatientGroup {
    @Id
    String id;

    @Field
    //Health ID for the therapist that this patient group belong to.
    String healthId;

    @Field
    //List of health IDs of patients that belong to the group
    List<PatientGroupPatient> patientIdList;
}
