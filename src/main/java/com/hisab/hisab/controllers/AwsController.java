package com.hisab.hisab.controllers;

import com.hisab.hisab.services.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsController {

    AwsService awsService;

    @Autowired
    public AwsController(AwsService awsService) {
        this.awsService = awsService;
    }

    @GetMapping("/presigned_url")
    public String getPreSignedUrlForImageUpload(@RequestParam("name") String name) {
        return awsService.generatePreSignedUrlForImageUpload("hisabImages", name);
    }
}
