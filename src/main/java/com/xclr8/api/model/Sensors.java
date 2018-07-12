package com.xclr8.api.model;

import com.xclr8.api.model.nestedModel.Sensor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Sensors")
public class Sensors {
    @Id
    String id;

    @Field
    String patientId;

    @Field
    List<Sensor> sensors;
}
