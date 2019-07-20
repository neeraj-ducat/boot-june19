package com.techmentro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;



@EnableOAuth2Sso
@SpringBootApplication
public class RestApplication 
{
	
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestApplication.class, args);
    }
}
