package com.techmentro.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements
    AuthenticationEntryPoint
{

	public void commence(HttpServletRequest request,
			HttpServletResponse response, 
			AuthenticationException ex)
			throws IOException, ServletException {
		
		 	response.setContentType("application/json");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.getOutputStream().println("{ \"error\": \"" + ex.getMessage() + "\" }");

		
	}

	
}
