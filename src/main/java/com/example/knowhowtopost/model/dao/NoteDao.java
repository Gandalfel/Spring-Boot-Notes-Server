package com.example.knowhowtopost.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class NoteDao implements Serializable {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private TagDao tag;

    /** Required no-args constructor.**/
    public NoteDao() { }
}
