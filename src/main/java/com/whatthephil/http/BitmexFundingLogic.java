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
		int dailyBtcCount = 3;
		double dailyBtc = 0;
		int threeDayBtcCount = 9;
		double threeDayBtc = 0;
		int weeklyBtcCount = 21;
		double weeklyBtc = 0;
		int twoWeeklyBtcCount = 42;
		double twoWeeklyBtc = 0;
		int monthlyBtcCount = 84;
		double monthlyBtc = 0;
		
		int dailyEthCount = 3;
		double dailyEth = 0;
		int threeDayEthCount = 9;
		double threeDayEth = 0;
		int weeklyEthCount = 21;
		double weeklyEth = 0;
		int twoWeeklyEthCount = 42;
		double twoWeeklyEth = 0;
		int monthlyEthCount = 84;
		double monthlyEth = 0;
		
		int dailyXrpCount = 3;
		double dailyXrp = 0;
		int threeDayXrpCount = 9;
		double threeDayXrp = 0;
		int weeklyXrpCount = 21;
		double weeklyXrp = 0;
		int twoWeeklyXrpCount = 42;
		double twoWeeklyXrp = 0;
		int monthlyXrpCount = 84;
		double monthlyXrp = 0;
				
		for (BitmexFunding bitmexFunding : bitmexFundingAll) {
			if (bitmexFunding.getSymbol().equals("XBTUSD")) {
				if (monthlyBtcCount > 0) {
					if (twoWeeklyBtcCount > 0) {
						if (weeklyBtcCount > 0) {
							if (threeDayBtcCount > 0) {
								if (dailyBtcCount > 0) {
									dailyBtc += bitmexFunding.getFundingRate();
									dailyBtcCount--;
								}
								threeDayBtc += bitmexFunding.getFundingRate();
								threeDayBtcCount--;
							}
							weeklyBtc += bitmexFunding.getFundingRate();
							weeklyBtcCount--;
						}
						twoWeeklyBtc += bitmexFunding.getFundingRate();
						twoWeeklyBtcCount--;
					}
					monthlyBtc += bitmexFunding.getFundingRate();
					monthlyBtcCount--;
				}
			}
			if (bitmexFunding.getSymbol().equals("ETHUSD")) {
				if (monthlyEthCount > 0) {
					if (twoWeeklyEthCount > 0) {
						if (weeklyEthCount > 0) {
							if (threeDayEthCount > 0) {
								if (dailyEthCount > 0) {
									dailyEth += bitmexFunding.getFundingRate();
									dailyEthCount--;
								}
								threeDayEth += bitmexFunding.getFundingRate();
								threeDayEthCount--;
							}
							weeklyEth += bitmexFunding.getFundingRate();
							weeklyEthCount--;
						}
						twoWeeklyEth += bitmexFunding.getFundingRate();
						twoWeeklyEthCount--;
					}
					monthlyEth += bitmexFunding.getFundingRate();
					monthlyEthCount--;
				}
			}
			if (bitmexFunding.getSymbol().equals("XRPUSD")) {
				if (monthlyXrpCount > 0) {
					if (twoWeeklyXrpCount > 0) {
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
						twoWeeklyXrp += bitmexFunding.getFundingRate();
						twoWeeklyXrpCount--;
					}
					monthlyXrp += bitmexFunding.getFundingRate();
					monthlyXrpCount--;
				}
			}
		}
		
		avgFundingRates.setBtcOneDayAvg((dailyBtc * 100) / 3);
		avgFundingRates.setBtcThreeDayAvg((threeDayBtc * 100) / 9);
		avgFundingRates.setBtcWeeklyAvg((weeklyBtc * 100) / 21);
		avgFundingRates.setBtcTwoWeeklyAvg((twoWeeklyBtc * 100) / 42);
		avgFundingRates.setBtcMonthlyAvg((monthlyBtc * 100) / 84);
		
		avgFundingRates.setEthOneDayAvg((dailyEth * 100) / 3);
		avgFundingRates.setEthThreeDayAvg((threeDayEth * 100) / 9);
		avgFundingRates.setEthWeeklyAvg((weeklyEth * 100) / 21);
		avgFundingRates.setEthTwoWeeklyAvg((twoWeeklyEth * 100) / 42);
		avgFundingRates.setEthMonthlyAvg((monthlyEth * 100) / 84);
		
		avgFundingRates.setXrpOneDayAvg((dailyXrp * 100) / 3);
		avgFundingRates.setXrpThreeDayAvg((threeDayXrp * 100) / 9);
		avgFundingRates.setXrpWeeklyAvg((weeklyXrp * 100) / 21);
		avgFundingRates.setXrpTwoWeeklyAvg((twoWeeklyXrp * 100) / 42);
		avgFundingRates.setXrpMonthlyAvg((monthlyXrp * 100) / 84);
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
