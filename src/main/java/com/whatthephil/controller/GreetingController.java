package com.whatthephil.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {

	@GetMapping("/")
	public String greeting() {
		return "greeting";
	}

	@GetMapping("/jstest")
	public String jstest() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "https://api.binance.com/api/v3/depth?symbol=XTZUSDT&limit=5000";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
		String respsone = response.getBody();
		System.out.println(response);
		
		return "jstest";
	}

}
