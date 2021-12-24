package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author SANZONG
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Value("${server.port}")
    int port;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        System.out.println(port);
        return userService.findUserById(id);
    }
}
