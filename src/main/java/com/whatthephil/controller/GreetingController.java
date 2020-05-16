package com.whatthephil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whatthephil.http.BitmexFundingLogic;
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
		BitmexFundingLogic bitmexFundingLogic = new BitmexFundingLogic();
		AvgFundingRates avgFundingRates = bitmexFundingLogic.getAvgFundingRates();
		model.addAttribute("avgFundingRates", avgFundingRates);
		return "greeting";
	}
	
}
