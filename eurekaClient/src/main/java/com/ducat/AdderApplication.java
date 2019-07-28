package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdderApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(AdderApplication.class, args);

	}

}
