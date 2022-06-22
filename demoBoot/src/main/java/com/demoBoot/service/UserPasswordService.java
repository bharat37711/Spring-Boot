package com.demoBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demoBoot.config.UserDetailConfig;
import com.demoBoot.dao.UserPasswordDao;
import com.demoBoot.entity.UserPassword;



@Service
public class UserPasswordService  implements UserDetailsService{

	@Autowired
	private UserPasswordDao dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	UserPassword obj=	this.dao.findByUsername(username);
	
	if(obj==null) {
		throw new UsernameNotFoundException(username+" : no user with yhis name");
	}
	
		return new UserDetailConfig(obj);
	}
	
	public String addUser(UserPassword obj) {
		
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		dao.save(obj);
		return "user added";
	}
	
}
