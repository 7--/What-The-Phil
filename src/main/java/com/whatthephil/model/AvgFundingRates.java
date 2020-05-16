package com.whatthephil.model;

import java.text.DecimalFormat;

public class AvgFundingRates {
	private double xrpOneDayAvg;
	private double xrpThreeDayAvg;
	private double xrpWeeklyAvg;
    private DecimalFormat df = new DecimalFormat("#.####%");


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
	
	
	
}
