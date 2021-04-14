package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.dao.UsersRepository;
import com.project.entity.Users;

public class MyUserDetailsServiceImpl  implements UserDetailsService{
	
	@Autowired
	public UsersRepository repositories;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users=this.repositories.getUsersUsername(username);
		if(users==null) {
			throw new UsernameNotFoundException("es wurde nicht gefunden");
		}
		return new MyUserDetails(users);
	}

}
