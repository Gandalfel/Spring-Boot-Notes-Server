package com.example.knowhowtopost.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TagDao {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String color;

}
