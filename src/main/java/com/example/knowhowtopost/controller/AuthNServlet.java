package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.model.UserDto;
import com.example.knowhowtopost.exception.InternalServerError;
import com.example.knowhowtopost.repository.UserRepository;
import com.example.knowhowtopost.model.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(path = "/REST/v1/AuthN")
public class AuthNServlet {

    @Autowired
    private UserRepository userRepository;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    @PostMapping(path = "/signUp")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto) {

        UserEntity userEntityByLogin = userRepository.findUserEntityByLogin(userDto.getLogin());
        UserEntity userEntityByEmail = userRepository.findUserEntityByEmail(userDto.getEmail());

        if (userEntityByLogin != null) {

            throw new InternalServerError("Chosen login isn't free. Choose another one.");

        } else if (userEntityByEmail != null) {

            throw new InternalServerError("Email is already used.");

        } else if (userDto.getLogin().length() <= 6) {

            throw new InternalServerError("Chosen login is too short or too long. Login length: 5-15.");

        } else if (userDto.getPassword().length() <= 9 || userDto.getPassword().length() >= 31) {

            throw new InternalServerError("Chosen password is too short or too long. Password length: 8-30.");

        } else if (!validateEmail(userDto.getEmail())) {

            throw new InternalServerError("Bad email format.");

        } else {

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

}
