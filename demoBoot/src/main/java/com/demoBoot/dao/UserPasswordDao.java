package com.demoBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoBoot.entity.UserPassword;

public interface  UserPasswordDao  extends JpaRepository<UserPassword, String>{

	public UserPassword findByUsername(String username);

}
