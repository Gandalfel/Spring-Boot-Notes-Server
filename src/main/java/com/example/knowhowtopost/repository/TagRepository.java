package com.example.knowhowtopost.repository;

import com.example.knowhowtopost.model.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository  extends CrudRepository<TagEntity, Long> {

    List<TagEntity> getAll();

}
