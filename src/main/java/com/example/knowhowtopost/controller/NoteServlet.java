package com.example.knowhowtopost.controller;

import com.example.knowhowtopost.model.dao.NoteDao;
import com.example.knowhowtopost.model.entity.NoteEntity;
import com.example.knowhowtopost.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/REST/v1/Notes")
public class NoteServlet {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping(path = "/{user}/createNote")
    public ResponseEntity createNote(@PathVariable String user, @RequestBody NoteDao noteDao) {

        noteRepository.save(new NoteEntity(
                noteDao.getTitle(),
                noteDao.getContent(),
                noteDao.getTag())
        );

        return new ResponseEntity(HttpStatus.CREATED);

    }

    @GetMapping(path = "/{user}/getAllNotes")
    public ResponseEntity<Iterable<NoteEntity>> getAllNotes(@PathVariable String user) {

        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);

    }

   /* @DeleteMapping
    public ResponseEntity deleteNote() {

    }*/
}
