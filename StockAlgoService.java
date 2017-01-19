package com.citi.trs.service;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.citi.trs.model.StockInfo;


@Component
public class StockAlgoService {

	//public List<StockInfo> getTop5Stocks(HttpServletRequest httRequest){
		public List<StockInfo> getTop5Stocks(){
			
	
		List<StockInfo> top5StockList=new ArrayList<StockInfo>();
		StockInfo stockInfo=new StockInfo();
		stockInfo.setSymbol("INFY");
		stockInfo.setName("Infosys");
		stockInfo.setPrice(1490.5);
		top5StockList.add(stockInfo);
		//Perform Algorithm
		return top5StockList;
				
			}
}
