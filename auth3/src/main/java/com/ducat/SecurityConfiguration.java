package com.ducat;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	//method to configure basic authentication for all requests.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
			.and()
			.httpBasic();
	}

	//To cofigure the Authentication mechanism i.e. database, ldap, in-memory etc.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("x@y.com").password(getEncoder().encode("abcd")).authorities("USER")
			.and()
			.passwordEncoder(getEncoder());
					
	}

	
	
}
