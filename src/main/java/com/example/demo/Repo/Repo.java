package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.otp.UserOtp;
import java.util.List;


public interface Repo extends JpaRepository<UserOtp,Long>{

	UserOtp findByEmail(String email);

	void save(String password);

	



	
}
