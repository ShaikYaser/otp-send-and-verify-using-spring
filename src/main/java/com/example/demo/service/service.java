package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.Repo;
import com.example.demo.otp.UserOtp;

@Service
public class service {

	@Autowired
	private Repo repo;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	private static final int OTP_LENGRH=6;
	
	private static String generatedOtp="";

	public String generateOtp() {
		Random random=new Random();
		generatedOtp=String.format("%0"+OTP_LENGRH+"d",random.nextInt((int)Math.pow(10, OTP_LENGRH)));
		return generatedOtp;
	}

	public void sendOtp(String email, String otp,String name,String password) {
		UserOtp userop=new UserOtp();
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		userop.setEmail(email);
		userop.setOtp(otp);
		userop.setName(name);
		userop.setPassword(password);
		message.setSubject("Your otp code");
		message.setText("Your otp code is:"+otp);
		javaMailSender.send(message);
		repo.save(userop);
		
	}

	public boolean verifyOtp(String email, String otp) {
		UserOtp user=repo.findByEmail(email);
		if(user !=null && user.getOtp().equals(otp)) {
		  user.setOtpVerify(true);
		  repo.save(user);
		  return true;
		}
		return false;
	}

}
