package com.techmentro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration 
extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(
    	ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient("techmentro")
        	.secret("oauthtest@123")
        	.authorizedGrantTypes("authorization_code")
            .scopes("read")
            .redirectUris("http://localhost:7070/client/authCode/");
    }
	
	
	

	
}