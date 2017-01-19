package com.citi.trs.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.trs.model.LoginResponse;
import com.citi.trs.model.UserModel;
import com.citi.trs.service.LoginService;
import com.citi.trs.service.StockAlgoService;

import jdk.nashorn.internal.runtime.logging.Logger;

@Controller
@RequestMapping("/")
public class MainController {
	
	//localhost:9080/CAPTRS/validateUser?userName=latika&password=latika
	
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	StockAlgoService stockAlgoService;
	
	
	@RequestMapping(value="/validateUser",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Object validateUser(@ModelAttribute UserModel userModel) throws Exception {
		
		System.out.println("Inside validate user");
		
		System.out.println("user name:"+userModel.getUserName());
		System.out.println("password:"+userModel.getPassword());
		
		String serviceResponse=loginService.validateUser(userModel);
		
		
		//return new LoginResponse(serviceResponse);
		return serviceResponse;
		
		
	}
	
	
	
	@RequestMapping(value="/getTop5Best",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Object getTop5Stocks(HttpServletRequest httRequest) throws Exception {
		
		String q = "ACC";
		String url = "http://finance.google.com/finance/info?client=ig&q=" + URLEncoder.encode(q, "UTF-8");
		System.out.println(url);
		//System.out.println(httRequest.getParameter("cap")));
		//String marketCapVal=httRequest.getParameter("capvalue");
		//return stockAlgoService.getTop5Stocks(marketCapVal);
		//String serviceResponse=StockAlgoService.getTop5Stocks(httRequest);
		
		return "stocks";
		
	}
	
	
	
}