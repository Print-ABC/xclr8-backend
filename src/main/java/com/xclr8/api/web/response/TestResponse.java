package com.xclr8.api.web.response;

import com.xclr8.api.model.Test;
import lombok.Data;

@Data
public class TestResponse {
    private String name;

    public static TestResponse toTestResponse(Test test){
        TestResponse testResponse = new TestResponse();
        testResponse.setName(test.getName());
        return testResponse;
    }
}
