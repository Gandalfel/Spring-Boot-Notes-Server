package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.dto.UserDto;
import com.example.knowhowtopost.exceptions.InternalServerError;
import com.example.knowhowtopost.repository.UserRepository;
import com.example.knowhowtopost.user.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/REST/v1/AuthN")
public class AuthNServlet {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/signIn")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto) {



        UserEntity userEntityTester = userRepository.findUserEntityByLogin(userDto.getLogin());

        if (userEntityTester != null) {

            throw new InternalServerError("User already exist. Choose another login.");

        }

        StringBuilder response = new StringBuilder();

        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);

        for (UserEntity u : userRepository.findAll()) {
            response.append(u.toString()).append("\n");
        }

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);

    }
}
