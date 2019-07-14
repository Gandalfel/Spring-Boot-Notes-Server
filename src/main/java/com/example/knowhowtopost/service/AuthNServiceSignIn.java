package com.example.knowhowtopost.service;

import com.example.knowhowtopost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthNServiceSignIn {

    @Autowired
    private UserRepository userRepository;



}
