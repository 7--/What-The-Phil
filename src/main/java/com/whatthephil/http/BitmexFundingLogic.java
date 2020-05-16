package com.whatthephil.http;

import java.time.Instant;

import org.springframework.web.client.RestTemplate;

import com.whatthephil.dto.BitmexFunding;
import com.whatthephil.model.AvgFundingRates;

public class BitmexFundingLogic {

	private static AvgFundingRates avgFundingRates;
	private static Instant lastCall;
	private static final long eightHoursInSeconds = 28800L;
	
	private BitmexFunding[] fundingCall() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://www.bitmex.com/api/v1/funding?symbol=&count=500&reverse=true";
		return restTemplate.getForObject(url, BitmexFunding[].class);
	}

	
	private void calculateAverages(BitmexFunding[] bitmexFundingAll) {
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
		BitmexFundingLogic.avgFundingRates = avgFundingRates;
	}


	public AvgFundingRates getAvgFundingRates() {
		if(avgFundingRates == null) {
			calculateAverages(fundingCall());
			lastCall = Instant.now();
		}
		Instant now = Instant.now();
		if(lastCall != null) {
			if(lastCall.plusSeconds(eightHoursInSeconds).isBefore(now)) {
				calculateAverages(fundingCall());
				lastCall = Instant.now();
			}
		}
		return avgFundingRates;
	}
}
