package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.model.UserDto;

import com.example.knowhowtopost.service.AuthNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/REST/v1/AuthN")
public class AuthNServlet {

    @Autowired
    private AuthNService authNService;

    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto) {

        return authNService.userDataValidation(userDto);

    }

}
