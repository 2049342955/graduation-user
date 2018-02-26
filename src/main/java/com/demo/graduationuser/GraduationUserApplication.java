package com.demo.graduationuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.demo.graduationuser.user.entity")
@SpringBootApplication
public class GraduationUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduationUserApplication.class, args);
	}
}
