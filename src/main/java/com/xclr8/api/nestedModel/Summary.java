package com.xclr8.api.nestedModel;

import lombok.Data;

@Data
public class Summary {
    /**
     Summary object to be stored in the Session objects in the database
     */

    //Stats
    double rangeOfMovement;
    double accuracy;
    //Duration stored in seconds
    int duration;

    //Feedback
    int painLevel;
    int difficulty;
    String feedback;
}
