package com.example.Okten_Java_Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OktenJavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktenJavaSpringbootApplication.class, args);
	}

}
