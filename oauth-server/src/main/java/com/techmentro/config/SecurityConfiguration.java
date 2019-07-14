package com.techmentro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends 
WebSecurityConfigurerAdapter {

   
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
    		return new BCryptPasswordEncoder();
    }
	
    
    

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder=passwordEncoder();
		auth.inMemoryAuthentication()
				.passwordEncoder(encoder)
				.withUser("neeraj")
				.password(encoder.encode("1234"))
				.roles("ADMIN");
		
	}




	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/emps").hasRole("ADMIN")
        		.anyRequest().authenticated()
        		.and()
        	.formLogin().permitAll()
        	    .and()
        	.csrf().disable();
    }

	
   
}
