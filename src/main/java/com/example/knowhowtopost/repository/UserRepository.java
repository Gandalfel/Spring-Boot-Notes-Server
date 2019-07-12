package com.example.knowhowtopost.repository;

import com.example.knowhowtopost.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { }