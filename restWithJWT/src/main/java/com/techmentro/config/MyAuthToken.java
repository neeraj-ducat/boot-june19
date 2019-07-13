package com.techmentro.config;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class MyAuthToken extends
   UsernamePasswordAuthenticationToken
{

	private String mailId;

	
	
	
	public MyAuthToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
			String mailId) {
		super(principal, credentials, authorities);
		this.mailId = mailId;
	}

	public MyAuthToken(Object principal, Object credentials, String mailId) {
		super(principal, credentials);
		this.mailId = mailId;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	
	
}
