package com.udaan.covidtracker.controller;

import com.udaan.covidtracker.entity.SelfAssessment;
import com.udaan.covidtracker.model.SelfAssessmentRequest;
import com.udaan.covidtracker.model.SelfAssessmentResponse;
import com.udaan.covidtracker.model.UserRequest;
import com.udaan.covidtracker.model.UserResponse;
import com.udaan.covidtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register/user/")
    public ResponseEntity<UserResponse> registerUsers(@RequestBody UserRequest userRequest){
        return new ResponseEntity<UserResponse>(userService.registerUser(userRequest),HttpStatus.CREATED);
    }

    @PostMapping("/assessment/")
    public ResponseEntity<SelfAssessmentResponse> selfAssessment(@RequestBody SelfAssessmentRequest selfAssessmentRequest){
        return new ResponseEntity<SelfAssessmentResponse>(userService.selfAssessment(selfAssessmentRequest), HttpStatus.CREATED);
    }
}
