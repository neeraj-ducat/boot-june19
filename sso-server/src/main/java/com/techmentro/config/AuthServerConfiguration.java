package com.techmentro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends 
		AuthorizationServerConfigurerAdapter {

   @Override
    public void configure(
    		ClientDetailsServiceConfigurer clients) throws Exception {
        
    	clients.inMemory()
    					.withClient("sso-rest")
    				    .secret("rest@sso").authorizedGrantTypes("authorization_code","refresh_token")
    				    .scopes("user").autoApprove(true)
    				    .and()
    				 .withClient("sso-web")
   					    .secret("web@sso").authorizedGrantTypes("authorization_code","refresh_token")
   					    .scopes("user").autoApprove(true);
    }
	

	@Override
    public void configure(
    	AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
    }
	

	
}