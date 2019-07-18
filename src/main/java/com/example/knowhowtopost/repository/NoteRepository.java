package com.example.knowhowtopost.repository;

import com.example.knowhowtopost.model.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Long> {

    List<NoteEntity> getAll();
}
