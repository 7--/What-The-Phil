package com.whatthephil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.event.AggTradeEvent;
import com.binance.api.client.domain.event.DepthEvent;

@Controller
public class BinanceContoller{

	@GetMapping("/binance")
	public String binance() {
		String symbol = "ethbtc";
		BinanceApiWebSocketClient client = BinanceApiClientFactory.newInstance().newWebSocketClient();
		client.onAggTradeEvent(symbol.toLowerCase(), new BinanceApiCallback<AggTradeEvent>() {
		    @Override
		    public void onResponse(final AggTradeEvent response) {
		        System.out.println(response);
		    }

		    @Override
		    public void onFailure(final Throwable cause) {
		        System.err.println("Web socket failed");
		        cause.printStackTrace(System.err);
		    }
		});
		client.onDepthEvent("ethbtc", (DepthEvent response) -> {
			  System.out.println(response.getAsks());
			 
			});
		return "binance";
		
	}

	

}
