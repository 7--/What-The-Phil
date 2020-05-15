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
		AvgFundingRates avgFundingRates = oneDayAvg(fundingCall());
		model.addAttribute("avgFundingRates", avgFundingRates);
		return "greeting";
	}

	private AvgFundingRates oneDayAvg(BitmexFunding[] bitmexFundingAll) {
		AvgFundingRates avgFundingRates = new AvgFundingRates();
		int dailyXrpCount = 3;
		double dailyXrp = 0;
		int threeDayXrpCount = 9;
		double threeDayXrp = 0;
		int weeklyXrpCount = 21;
		double weeklyXrp = 0;
		for (BitmexFunding bitmexFunding : bitmexFundingAll) {
			if (bitmexFunding.getSymbol().equals("XRPUSD")) {
				if (weeklyXrpCount > 0) {
					if (threeDayXrpCount > 0) {
						if (dailyXrpCount > 0) {
							dailyXrp += bitmexFunding.getFundingRate();
							dailyXrpCount--;
						}
						threeDayXrp += bitmexFunding.getFundingRate();
						threeDayXrpCount--;
					}
					weeklyXrp += bitmexFunding.getFundingRate();
					weeklyXrpCount--;
				}		
			}
		}
		avgFundingRates.setXrpOneDayAvg((dailyXrp * 100) / 3);
		avgFundingRates.setXrpThreeDayAvg((threeDayXrp * 100) / 9);
		avgFundingRates.setXrpWeeklyAvg((weeklyXrp * 100) / 21);
		return avgFundingRates;
	}

	public BitmexFunding[] fundingCall() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.bitmex.com/api/v1/funding?symbol=&count=500&reverse=true";
		return restTemplate.getForObject(url, BitmexFunding[].class);
	}

}
