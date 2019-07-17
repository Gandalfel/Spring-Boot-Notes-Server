package com.example.knowhowtopost.model.dto;

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
    private int id;

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String email;

    /** Required no-args constructor.**/
    public UserDto() { }

}
