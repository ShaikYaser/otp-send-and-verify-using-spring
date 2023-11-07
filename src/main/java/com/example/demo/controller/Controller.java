package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.service;

@RestController
@RequestMapping("/otp")
public class Controller {

	@Autowired
	private service Service;
	
	@PostMapping("/send")
	public String sendOtp(@RequestParam String email,@RequestParam String name,@RequestParam String password) {
		String otp=Service.generateOtp();

		Service.sendOtp(email,otp,name,password);
		return "Otp send to your email address.";
	}
	
	@PostMapping("/verify")
	public String verifyOtp(@RequestParam String email,@RequestParam String otp) {
		if(Service.verifyOtp(email,otp)) {
			return "verify";
		}else {
			return "not verify";
			
		}
	}
}
