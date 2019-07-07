package com.ducat.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ducat.daos.UserDao;
import com.ducat.entities.User;

@Component
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	private UserDao dao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		Optional<User> optional=dao.findByMailId(username);
		if(optional.isPresent())
		{
			User user=optional.get();
			System.out.println(user.getName()+" is loaded.");			
			UserDetails userDetails=
					org.springframework.security.core.userdetails.User.builder()
					.username(user.getName())
					.password(encoder.encode(user.getPassword()))
					.accountExpired(false)
					.roles(user.getRoles())
					.build();
			return userDetails;
		}
		else
		{	
		throw(new UsernameNotFoundException("No user found for username "+username));
		}
		}

	
}
