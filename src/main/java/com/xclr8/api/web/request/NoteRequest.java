package com.xclr8.api.web.request;

import lombok.Data;

@Data
public class NoteRequest {
    String diagnosisId;
    int noteId;
    String date;
    String text;
}
