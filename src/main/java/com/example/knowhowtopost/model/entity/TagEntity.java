package com.example.knowhowtopost.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@ToString
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @Column(unique = true)
    @Getter
    @Setter
    private String color;
}
