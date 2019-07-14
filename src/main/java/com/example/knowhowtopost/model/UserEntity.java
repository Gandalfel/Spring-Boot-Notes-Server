package com.example.knowhowtopost.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    @Getter
    @Setter
    private String login;

    @Column
    @Getter
    @Setter
    private String password;

    @Column(unique = true)
    @Getter
    @Setter
    private String email;

}
