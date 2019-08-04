package com.ducat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubtractorServiceApp {

	public static void main(String[] args) {
		
		SpringApplication.run(SubtractorServiceApp.class, args);

	}

}
