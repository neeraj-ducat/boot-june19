package com.techmentro.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techmentro.config.JWTConfig;
import com.techmentro.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class TokenController {

	@PostMapping("/token")
	public String getToken(
			@RequestBody User user)
	{
		//The user is authenticated using the
		//CustomUserDetailsService and if
		//credentials are valid a JWT is issued
		
		//Creating JWT using the user credentials
		Map<String, Object> claims
		=new HashMap<String, Object>();
		claims.put("usr",user.getUsername());
		claims.put("mid",user.getUsername()+"@gmail.com");
		claims.put("iss",JWTConfig.Issuer);
		claims.put("rol","ADMIN,MODERATOR");
		
		String token = Jwts.builder()
				 .setClaims(claims)
				  .signWith(SignatureAlgorithm.HS512, JWTConfig.SecretKey)
				  .compact();
		System.out.println("returning the following token: "+token);
		return token;
	}
}










