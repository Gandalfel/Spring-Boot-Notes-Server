package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.dto.UserDto;
import com.example.knowhowtopost.exceptions.InternalServerError;
import com.example.knowhowtopost.repository.UserRepository;
import com.example.knowhowtopost.entities.UserEntity;

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

    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto) {

        UserEntity userEntityTester = userRepository.findUserEntityByLogin(userDto.getLogin());

        if (userEntityTester != null) {

            throw new InternalServerError("Login already exist. Choose another login.");

        } else if (userDto.getLogin().length() <= 6 || userDto.getLogin().length() <= 16) {

            throw new InternalServerError("Chosen login is too short or too long. Login length must be longer equal or more than 5 and less than 15 words.");

        } else if (userDto.getPassword().length() <= 9) {

            throw new InternalServerError("Chosen password is too short. Password length must be longer equal or more than 8 words.");

        } else if (false /* EMAIL VALIDATION */) {

            throw new InternalServerError("Chosen email is incorrect. You should check if chosen email contains at (@), domain (.com, .org etc.).");

        }

        StringBuilder response = new StringBuilder();

        UserEntity user = new UserEntity();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);

        for (UserEntity u : userRepository.findAll()) {
            response.append(u.toString()).append("\n");
        }

        return new ResponseEntity<>(response.toString(), HttpStatus.OK);

    }
}
