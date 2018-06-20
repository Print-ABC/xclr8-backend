package com.xclr8.api.service;

import com.xclr8.api.model.Test;
import com.xclr8.api.repository.TestRepository;
import com.xclr8.api.web.request.TestRequest;
import com.xclr8.api.web.response.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    public TestResponse createTest(TestRequest request){
        Test test = new Test();
        test.setName(request.getName());
        test = testRepository.save(test);
        return TestResponse.toTestResponse(test);
    }
}
