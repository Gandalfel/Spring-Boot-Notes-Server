package com.example.knowhowtopost.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class TagDao implements Serializable {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String color;

}
