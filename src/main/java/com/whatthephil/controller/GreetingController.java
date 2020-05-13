package com.whatthephil.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.whatthephil.dto.BitmexFunding;
import com.whatthephil.model.AvgFundingRates;

@Controller
public class GreetingController {

	
	@GetMapping("/.well-known/acme-challenge/92da9-VSaIB-FGZ8vXji0SNog0HOyP4581xR7xwhePM")
	@ResponseBody
	public String wellknown() {
		return "92da9-VSaIB-FGZ8vXji0SNog0HOyP4581xR7xwhePM._C58mQk55lmZNmP0PSWBPQmTcPk4fBZWNuNgkpoKc3Q";
	}
	
	
	@GetMapping("/")
	public String greeting(ModelMap model) {
		double oneDayAvg = oneDayAvg(fundingCall());
		model.addAttribute("oneDayAvg", oneDayAvg);
		return "greeting";
	}

	private double oneDayAvg(BitmexFunding[] bitmexFundingAll) {
		int dailyXrp = 3;
		double dailyXrpAvg = 0;
		for(BitmexFunding bitmexFunding: bitmexFundingAll) {
			if(bitmexFunding.getSymbol().equals("XRPUSD")) {
				if(dailyXrp>0) {
					dailyXrpAvg += bitmexFunding.getFundingRate();
					dailyXrp--;
				}
			}
		}
		dailyXrpAvg = (dailyXrpAvg * 100) / 3;
		return dailyXrpAvg;
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
	
	public BitmexFunding[] fundingCall() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.bitmex.com/api/v1/funding?symbol=&count=500&reverse=true";
		return restTemplate.getForObject(url, BitmexFunding[].class);
	}

}
