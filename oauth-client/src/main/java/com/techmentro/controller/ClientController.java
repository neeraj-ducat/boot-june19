package com.techmentro.controller;


import java.util.Arrays;
import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techmentro.models.AccessToken;
import com.techmentro.models.Constants;
import com.techmentro.models.Emp;

@Controller
@RequestMapping("/client")
public class ClientController {

	@RequestMapping(value = "/getToken", method = RequestMethod.GET)
	public String getAuthToken() {
		   
		return "getToken";
	}
	
	@RequestMapping(value = "/authCode", method = RequestMethod.GET)
	public ModelAndView authCode( @RequestParam String code) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		System.out.println("Auth code is: "+code);
		mav.setViewName("authCode");
		mav.addObject("code",code);
		// Fetching accessToken using the authCode
		String token = getAccessToken(code);
		mav.setViewName("token");
		mav.addObject("token",token);
		
		// Fetching employees data using the access token
		Emp[] empList = getProtectedResource(token);
		mav.setViewName("result");
		mav.addObject("empList", empList);
		
		return mav;
		
		
		
	}
	
	private String getAccessToken(String code) throws Exception
	{
		RestTemplate restTemplate = new RestTemplate();
		
		//Encoding  client id and secret key using Base64
		String credentials = Constants.CLIENT+":"+Constants.SECRET;
		String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = Constants.AUTH_SERVER_URL;
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
			
		System.out.println("Sending request to fetch access token "+access_token_url);
		ResponseEntity<String> response = 
			restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token :" + response.getBody());
		
		// Get the Access Token From the received JSON response
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();
		
		return token;		


	}
	
	private Emp[] getProtectedResource(String accessToken) {
		// Using the access token to fetch protected resource from the server
		String url = "http://localhost:8080/emps";	
		
		HttpHeaders resource_headers = new HttpHeaders();
		resource_headers.add("Authorization", "Bearer "+ accessToken);
		HttpEntity<String> entity = new HttpEntity<String>(resource_headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Emp[]> res = restTemplate.exchange(url, HttpMethod.GET, entity, Emp[].class);
		System.out.println(res);
		Emp[] emps = res.getBody();
		return emps;

	}
}
