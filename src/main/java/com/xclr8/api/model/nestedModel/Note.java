package com.xclr8.api.model.nestedModel;

import lombok.Data;

@Data
public class Note {
    /**
        Note object to be stored in the Diagnosis objects in the database
     */

    int noteId;
    String date;
    String text;
}
