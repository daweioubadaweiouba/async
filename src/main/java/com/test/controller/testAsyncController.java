package com.test.controller;

import com.test.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testAsyncController")
public class testAsyncController {

//    @Autowired
    private AsyncService asyncService;

    public testAsyncController(AsyncService asyncService){
        this.asyncService = asyncService;
    }

    @GetMapping(value = "/testAsync")
    public String testAsync(){
        return asyncService.AsyncServer();
    }

    @GetMapping(value = "/test")
    public String test(){
        return asyncService.Server();
    }

}
