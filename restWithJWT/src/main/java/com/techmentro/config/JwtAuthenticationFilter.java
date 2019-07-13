package com.techmentro.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtAuthenticationFilter extends
  OncePerRequestFilter
{
	@Autowired
	JwtEntryPoint entryPoint;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException 
	{
		
		//From the request, Authorization header is fetched
		String header=request.getHeader(JWTConfig.Header);
	try {	
		
		SecurityContext context=SecurityContextHolder.getContext();
			if(header !=null)
			{
			header=header.replaceAll(JWTConfig.Token_Prefix, "");
			System.out.println("Following header is received: "+header);
			//The token is parsed
			try {
			    Jws<Claims> claims = Jwts.parser()
			        .requireIssuer(JWTConfig.Issuer)
			        .setSigningKey(JWTConfig.SecretKey)
			        .parseClaimsJws(header);
			      
			    //claims are obtained from the parse token
			     String user=(String)claims.getBody().get("usr");
			     String mailId=(String)claims.getBody().get("mid");
			     String roles=(String)claims.getBody().get("rol");
				    
			     //A list of GrantedAuthority objects is created
			     //for the received roles
			     String authorites[]=roles.split(",");
			     List<GrantedAuthority> list=new 
			    		 ArrayList<GrantedAuthority>();
			     for(String role:authorites)
			    	   list.add(new SimpleGrantedAuthority(role));
			    	 
			     //An Authentication object is created using the token claims
			     MyAuthToken token=new MyAuthToken(
			    		 			user,null,list,mailId);
			     //Authentication object is stored in the
			     //security context
			     context.setAuthentication(token);
			    
				} catch (Exception e)
					{
						throw (new BadCredentialsException(e.getMessage()));
					}
				
			}
		
			//next component of the filter chain is invoked
			chain.doFilter(request, response);
			//Authentication object is removed from the context
			context.setAuthentication(null);
			
		}
		catch(AuthenticationException ex)
		{
		//EntryPoint should be commenced.
			entryPoint.commence(request, response, ex);
		}
	}

}
