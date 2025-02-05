package com.cdac.orderease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.cdac.orderease.config.RazorpayConfig;

@SpringBootApplication
@EnableConfigurationProperties(RazorpayConfig.class)
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
