package com.whatthephil.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitmexFunding {
	private String timestamp;
	private String symbol;
	private String fundingInterval;
	private double fundingRate;
	private double fundingRateDaily;

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setFundingInterval(String fundingInterval) {
		this.fundingInterval = fundingInterval;
	}

	public String getFundingInterval() {
		return this.fundingInterval;
	}

	public void setFundingRate(double fundingRate) {
		this.fundingRate = fundingRate;
	}

	public double getFundingRate() {
		return this.fundingRate;
	}

	public void setFundingRateDaily(double fundingRateDaily) {
		this.fundingRateDaily = fundingRateDaily;
	}

	public double getFundingRateDaily() {
		return this.fundingRateDaily;
	}
}
