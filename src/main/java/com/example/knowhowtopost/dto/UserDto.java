package com.example.knowhowtopost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class UserDto implements Serializable {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    public UserDto() { }

}
