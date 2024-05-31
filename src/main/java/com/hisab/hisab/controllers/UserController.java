package com.hisab.hisab.controllers;

import com.hisab.hisab.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    @ResponseBody
    public void addUserDetails(User user) {

    }
}
