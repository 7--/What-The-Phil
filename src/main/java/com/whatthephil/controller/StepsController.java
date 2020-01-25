package com.whatthephil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StepsController implements Runnable {

	@GetMapping("/steps")
	public String steps() {
		return "steps";
		
	}

	@GetMapping("/learn")
	public String arthur() {
		return "learn";
		
	}
	
	@GetMapping("/twitter")
	public String twitter() {
		return "twitter";
		
	}
	
	@GetMapping("/heythere/*")
	@ResponseBody
	public String arthurall() {
		return "oh noo";
		
	}

	@GetMapping("discordlinux")
	@ResponseBody
	public String discordlinux() {
		return "hey wtf man";
		
	}
	
	@Override
	public void run() {
		System.out.println("1");// 2113
	}

}
