package com.example.knowhowtopost.servlet;

import com.example.knowhowtopost.dto.UserDto;
import com.example.knowhowtopost.repository.UserRepository;
import com.example.knowhowtopost.user.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String signIn(@RequestBody UserDto userDto) {

        StringBuilder response = new StringBuilder();

        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);

        for (User u : userRepository.findAll()) {
            response.append(u.toString()).append("\n");
        }

        return response.toString();

    }
}
