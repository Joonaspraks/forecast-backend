package com.yotproov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class YotproovApplication {

	public static void main(String[] args) {
		SpringApplication.run(YotproovApplication.class, args);
	}

}
