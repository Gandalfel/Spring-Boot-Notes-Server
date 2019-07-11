package com.example.knowhowtopost;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/REST/v1/AuthN")
public class AuthNServlet {

    @PostMapping(path = "/signIn")
    public String signIn(@RequestBody UserDto userDto) {

        return userDto.toString();

    }
}
