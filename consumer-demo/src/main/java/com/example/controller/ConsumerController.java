package com.example.controller;

import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
public class ConsumerController {
    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        String url = "http://user-service/user/"+id;
        return restTemplate.getForObject(url,User.class);
    }
}

