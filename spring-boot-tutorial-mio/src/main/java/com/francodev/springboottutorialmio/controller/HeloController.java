package com.francodev.springboottutorialmio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloController {

    @GetMapping(value = "/")
    public String helloWorld(){
        return "welcome to moril rest api";
    }
}
