package com.example.knowhowtopost.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
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
