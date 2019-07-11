package com.example.knowhowtopost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDto {

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String password;

    public UserDto() { }

}
