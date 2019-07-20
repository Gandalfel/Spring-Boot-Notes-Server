package com.example.knowhowtopost.repository;

import com.example.knowhowtopost.model.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Long> {


}
