package com.amol.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amol.spring.data.jpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
}