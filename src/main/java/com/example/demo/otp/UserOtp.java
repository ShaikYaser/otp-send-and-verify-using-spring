package com.example.demo.otp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserOtp")
public class UserOtp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String otp;
	private boolean isOtpVerify;
	public UserOtp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserOtp(Long id, String name, String email, String password, String otp, boolean isOtpVerify) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.otp = otp;
		this.isOtpVerify = isOtpVerify;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isOtpVerify() {
		return isOtpVerify;
	}


	public void setOtpVerify(boolean isOtpVerify) {
		this.isOtpVerify = isOtpVerify;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	
}
