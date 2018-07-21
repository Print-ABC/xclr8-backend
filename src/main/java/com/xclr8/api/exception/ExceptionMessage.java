package com.xclr8.api.exception;

public enum ExceptionMessage {
    EMPTY("No resource(s) found whatsoever."),

    INVALID_REQUEST("Either the service you are accessing does not exist, the request method or destination URI is wrong."),

    RESOURCE_NOT_FOUND("Requested resource(s) not found."),

    REQUEST_BODY_ERROR("Request body or object to be submitted is either missing or has bad fields.");

    private final String msg;

    ExceptionMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
