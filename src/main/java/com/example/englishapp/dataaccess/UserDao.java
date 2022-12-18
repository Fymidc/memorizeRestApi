package com.example.englishapp.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.englishapp.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

	User findUserByUserName(String username);
}
