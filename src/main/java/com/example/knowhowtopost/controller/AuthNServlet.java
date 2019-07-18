package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.exception.InternalServerError;
import com.example.knowhowtopost.model.dto.UserDto;
import com.example.knowhowtopost.model.dto.UsersObjectsDto;
import com.example.knowhowtopost.service.AuthNServiceSignIn;
import com.example.knowhowtopost.service.AuthNServiceSignUp;

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
    private AuthNServiceSignUp authNServiceSignUp;
    private AuthNServiceSignIn authNServiceSignIn;

    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {

        return authNServiceSignUp.userDataValidation(userDto);

    }

    @PostMapping(path = "/signIn")
    public ResponseEntity<UsersObjectsDto> signIn(@RequestBody UserDto userDto) {

        if (authNServiceSignIn.userDataValidation(userDto)) {

            return authNServiceSignIn.getUsersObjects(userDto);

        }

        throw new InternalServerError(
                "You shouldn't see this message. The server encountered an error with validation your data");

    }

}
