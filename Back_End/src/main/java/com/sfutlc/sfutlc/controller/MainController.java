package com.sfutlc.sfutlc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getmap")
public class MainController {
    @GetMapping
    public String sayHello() {
        return "Hello this is TLC  DM Project.";
    }
}
