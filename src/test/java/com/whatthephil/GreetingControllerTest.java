package com.whatthephil;

import org.junit.Test;

import com.whatthephil.controller.BinanceContoller;
import com.whatthephil.controller.GreetingController;

public class GreetingControllerTest {

	
	@Test
	public void restCall() {
		GreetingController greetingController = new GreetingController();
		 greetingController.jstest();
		 
	}
	
	@Test
	public void BinanceController() {
		BinanceContoller binanceController = new BinanceContoller();
		binanceController.binance();		 
	}
	
	
}
