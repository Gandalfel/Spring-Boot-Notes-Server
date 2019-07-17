package com.example.knowhowtopost.service;

import com.example.knowhowtopost.model.dto.UserDto;
import com.example.knowhowtopost.model.dto.UsersObjectsDto;
import com.example.knowhowtopost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthNServiceSignIn {

    @Autowired
    private UserRepository userRepository;

    public boolean userDataValidation(UserDto userDto) {

        if () {

        }

        return false;

    }

    public UsersObjectsDto getUsersObjects(UserDto userDto) {



    }

}
