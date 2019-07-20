package com.example.knowhowtopost.service;

import com.example.knowhowtopost.exception.InternalServerError;
import com.example.knowhowtopost.model.dao.NoteDao;
import com.example.knowhowtopost.model.dao.TagDao;
import com.example.knowhowtopost.model.dto.UserDto;
import com.example.knowhowtopost.model.dto.UsersObjectsDto;
import com.example.knowhowtopost.model.entity.NoteEntity;
import com.example.knowhowtopost.model.entity.TagEntity;
import com.example.knowhowtopost.model.entity.UserEntity;
import com.example.knowhowtopost.repository.NoteRepository;
import com.example.knowhowtopost.repository.TagRepository;
import com.example.knowhowtopost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthNServiceSignIn {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TagRepository tagRepository;

    public boolean userDataValidation(UserDto userDto) {

        UserEntity userEntityIfExistTest =
                userRepository.findUserEntityByLogin(userDto.getLogin());

        if (userEntityIfExistTest == null) {

            throw new InternalServerError(
                    "Account doesn't exist or typed data aren't correct.");

        }

        return true;

    }

    public ResponseEntity<UsersObjectsDto> getUsersObjects(UserDto userDto) {

        ArrayList<NoteDao> notes = new ArrayList<>();
        for (NoteEntity n : noteRepository.findAll()) {
            notes.add(new NoteDao(n.getTitle(), n.getContent(), n.getTag()));
        }

        ArrayList<TagDao> tags = new ArrayList<>();
        for (TagEntity t : tagRepository.findAll()) {
            tags.add(new TagDao(t.getName(), t.getColor()));
        }

        return new ResponseEntity<>(new UsersObjectsDto(notes, tags), HttpStatus.OK);
    }

}
