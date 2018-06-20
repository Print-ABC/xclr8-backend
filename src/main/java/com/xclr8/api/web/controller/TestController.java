package com.xclr8.api.web.controller;

import com.xclr8.api.service.TestService;
import com.xclr8.api.web.request.TestRequest;
import com.xclr8.api.web.response.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test(){
        return "hello world";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public TestResponse testCreate(@RequestBody TestRequest test){
        return testService.createTest(test);
    }
}
