package com.techmentro.daos;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.techmentro.entities.User;

@Service
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDao dao;
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		//loading user from the db
		List<User> list=dao.loadUser(userName);
		if(list.isEmpty())
			throw (new UsernameNotFoundException("No user found for the username "+userName));
		else
		{
			User loaded=list.get(0);
			UserBuilder builder= 
                org.springframework.security.core.userdetails.User.withUsername(loaded.getMailId());
			
			return  builder.password(loaded.getPassword())
					 .roles("USER")
					 .build();
					  
			
		}
		
		
		
	}
	
	
	
}













