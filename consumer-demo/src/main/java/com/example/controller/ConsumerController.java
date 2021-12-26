package com.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author SANZONG
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "fallAll")
public class ConsumerController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @GetMapping("/{id}")
    @HystrixCommand
    public String getUser(@PathVariable int id) {
        String url = "http://user-service/user/"+id;
        return restTemplate.getForObject(url,String.class);
    }

    public String findUserFallBack(int id) {
        return "Unavailable";
    }

    public String fallAll() {
        return "all unavailable";
    }
}

