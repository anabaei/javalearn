package com.sfutlc.sfutlc.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class IndexController {
	
    @GetMapping
    public  String getEmployees()
    {
        final String uri = "https://api.github.com/users";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
         return result;
       // testing back end talk to another API end point;
    }
}
