package com.example.demo.controller;


import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	public static final String URL = "https://apitest.msdigital34.fr/api/plat";

	static RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callGetAll();
	}
	
	private static void callGetAll() {
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
}
