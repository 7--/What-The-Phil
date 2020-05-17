package com.whatthephil.model;

import java.text.DecimalFormat;

public class AvgFundingRates {
	private double btcOneDayAvg;
	private double btcThreeDayAvg;
	private double btcWeeklyAvg;
	private double btcTwoWeeklyAvg;
	private double btcMonthlyAvg;
	
	private double ethOneDayAvg;
	private double ethThreeDayAvg;
	private double ethWeeklyAvg;
	private double ethTwoWeeklyAvg;
	private double ethMonthlyAvg;
	
	private double xrpOneDayAvg;
	private double xrpThreeDayAvg;
	private double xrpWeeklyAvg;
	private double xrpTwoWeeklyAvg;
	private double xrpMonthlyAvg;

    private DecimalFormat df = new DecimalFormat("#.####");

    
    public double getBtcOneDayAvg() {
		return btcOneDayAvg;
	}
	
	public String getBtcOneDayAvgF() {
		return df.format(btcOneDayAvg);
	}

	public void setBtcOneDayAvg(double btcOneDayAvg) {
		this.btcOneDayAvg = btcOneDayAvg;
	}

	public double getBtcThreeDayAvg() {
		return btcThreeDayAvg;
	}
	
	public String getBtcThreeDayAvgF() {
		return df.format(btcThreeDayAvg);
	}

	public void setBtcThreeDayAvg(double btcThreeDayAvg) {
		this.btcThreeDayAvg = btcThreeDayAvg;
	}

	public double getBtcWeeklyAvg() {
		return btcWeeklyAvg;
	}

	public String getBtcWeeklyAvgF() {
		return df.format(btcWeeklyAvg);
	}
	
	public void setBtcWeeklyAvg(double btcWeeklyAvg) {
		this.btcWeeklyAvg = btcWeeklyAvg;
	}

	public double getBtcTwoWeeklyAvg() {
		return btcTwoWeeklyAvg;
	}

	public String getBtcTwoWeeklyAvgF() {
		return df.format(btcTwoWeeklyAvg);
	}
	
	public void setBtcTwoWeeklyAvg(double btcTwoWeeklyAvg) {
		this.btcTwoWeeklyAvg = btcTwoWeeklyAvg;
	}

	public double getBtcMonthlyAvg() {
		return btcMonthlyAvg;
	}
	
	public String getBtcMonthlyAvgF() {
		return df.format(btcMonthlyAvg);
	}

	public void setBtcMonthlyAvg(double btcMonthlyAvg) {
		this.btcMonthlyAvg = btcMonthlyAvg;
	}
    
	
	public double getEthOneDayAvg() {
		return ethOneDayAvg;
	}
	
	public String getEthOneDayAvgF() {
		return df.format(ethOneDayAvg);
	}

	public void setEthOneDayAvg(double ethOneDayAvg) {
		this.ethOneDayAvg = ethOneDayAvg;
	}

	public double getEthThreeDayAvg() {
		return ethThreeDayAvg;
	}
	
	public String getEthThreeDayAvgF() {
		return df.format(ethThreeDayAvg);
	}

	public void setEthThreeDayAvg(double ethThreeDayAvg) {
		this.ethThreeDayAvg = ethThreeDayAvg;
	}

	public double getEthWeeklyAvg() {
		return ethWeeklyAvg;
	}

	public String getEthWeeklyAvgF() {
		return df.format(ethWeeklyAvg);
	}
	
	public void setEthWeeklyAvg(double ethWeeklyAvg) {
		this.ethWeeklyAvg = ethWeeklyAvg;
	}

	public double getEthTwoWeeklyAvg() {
		return ethTwoWeeklyAvg;
	}

	public String getEthTwoWeeklyAvgF() {
		return df.format(ethTwoWeeklyAvg);
	}
	
	public void setEthTwoWeeklyAvg(double ethTwoWeeklyAvg) {
		this.ethTwoWeeklyAvg = ethTwoWeeklyAvg;
	}

	public double getEthMonthlyAvg() {
		return ethMonthlyAvg;
	}
	
	public String getEthMonthlyAvgF() {
		return df.format(ethMonthlyAvg);
	}

	public void setEthMonthlyAvg(double ethMonthlyAvg) {
		this.ethMonthlyAvg = ethMonthlyAvg;
	}
	

	public double getXrpOneDayAvg() {
		return xrpOneDayAvg;
	}
	
	public String getXrpOneDayAvgF() {
		return df.format(xrpOneDayAvg);
	}

	public void setXrpOneDayAvg(double xrpOneDayAvg) {
		this.xrpOneDayAvg = xrpOneDayAvg;
	}

	public double getXrpThreeDayAvg() {
		return xrpThreeDayAvg;
	}
	
	public String getXrpThreeDayAvgF() {
		return df.format(xrpThreeDayAvg);
	}

	public void setXrpThreeDayAvg(double xrpThreeDayAvg) {
		this.xrpThreeDayAvg = xrpThreeDayAvg;
	}

	public double getXrpWeeklyAvg() {
		return xrpWeeklyAvg;
	}

	public String getXrpWeeklyAvgF() {
		return df.format(xrpWeeklyAvg);
	}
	
	public void setXrpWeeklyAvg(double xrpWeeklyAvg) {
		this.xrpWeeklyAvg = xrpWeeklyAvg;
	}

	public double getXrpTwoWeeklyAvg() {
		return xrpTwoWeeklyAvg;
	}

	public String getXrpTwoWeeklyAvgF() {
		return df.format(xrpTwoWeeklyAvg);
	}
	
	public void setXrpTwoWeeklyAvg(double xrpTwoWeeklyAvg) {
		this.xrpTwoWeeklyAvg = xrpTwoWeeklyAvg;
	}

	public double getXrpMonthlyAvg() {
		return xrpMonthlyAvg;
	}
	
	public String getXrpMonthlyAvgF() {
		return df.format(xrpMonthlyAvg);
	}

	public void setXrpMonthlyAvg(double xrpMonthlyAvg) {
		this.xrpMonthlyAvg = xrpMonthlyAvg;
	}
}
