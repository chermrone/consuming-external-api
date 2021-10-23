package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.LoginResponse;
import com.example.demo.entities.Plat;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/test")
public class TestController {

	public static final String URL = "https://apitest.msdigital34.fr/api/plat";
	static RestTemplate restTemplate = new RestTemplate();

	@GetMapping("test1")
	private static void callGetAll() {
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}

	@GetMapping("add1")
	private void callCreate() {
		Plat p = new Plat((long) 1, "plat1", 123, "Descriptio plat1", "image", true);
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.out.println("------------->" + p.toString());
		ResponseEntity<Plat> response = restTemplate.postForEntity("https://apitest.msdigital34.fr/api/platopen", p,
				Plat.class);
		System.out.println("------------->" + response.getBody());
	}

	@GetMapping("login")
	private void login() throws IOException {
		User u = new User();
		u.setLogin("marouen113");
		u.setPassword("Djerba007");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		ResponseEntity<LoginResponse> response = restTemplate.postForEntity("https://apitest.msdigital34.fr/api/login",
				u, LoginResponse.class);
		System.out.println("------------->" + response.getBody().getJwt());
		String jwt = "Bearer " + response.getBody().getJwt();
		this.whenWriteStringUsingBufferedWritter_thenCorrect(jwt);
		Plat p = new Plat((long) 1, "abcd", 123, "Descriptio abcd", "efgh", true);
		HttpEntity<Plat> request = new HttpEntity<>(p, headers);
		String jwt1 = this.read();
		headers.set("Authorization", jwt);
		System.out.println(jwt1);
		ResponseEntity<Plat> response1 = restTemplate.postForEntity("https://apitest.msdigital34.fr/api/plat", request,
				Plat.class);
		System.out.println("------------->" + response1.getBody());

	}

	public void whenWriteStringUsingBufferedWritter_thenCorrect(String jwt) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("myFile.txt"));
		writer.write(jwt);

		writer.close();
	}

	public String read() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
		StringBuilder str = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			str.append(line).append("\n");
		}
		return str.toString();
	}

	@GetMapping("update")
	private void callUpdate() {
		Plat p = new Plat((long) 55, "plat3", 123, "Descriptio plat1", "image", true);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		restTemplate.put("https://apitest.msdigital34.fr/api/platupdate", p);
	}

	@GetMapping("delete")
	private void callDelete() {
		restTemplate.delete("https://apitest.msdigital34.fr/api/platdelete/" + 55);
		System.out.println("https://apitest.msdigital34.fr/api/platdelete/" + 55);
	}

}
