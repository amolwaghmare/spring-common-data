package com.amol.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
}