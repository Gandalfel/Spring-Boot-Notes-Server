package com.example.knowhowtopost.model.entity;

import com.example.knowhowtopost.model.dao.TagDao;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "notes")
@ToString
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
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

    public NoteEntity(String title, String content, TagDao tag) {
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

    /** Required no-args constructor.**/
    public NoteEntity() { }
}
