package com.example.knowhowtopost.model.dto;

import com.example.knowhowtopost.model.dao.NoteDao;
import com.example.knowhowtopost.model.dao.TagDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
public class UsersObjectsDto {

    @Getter
    @Setter
    private List<NoteDao> notes;

    @Getter
    @Setter
    private List<TagDao> tags;

    /** Required no-args constructor.**/
    public UsersObjectsDto() { }
}
