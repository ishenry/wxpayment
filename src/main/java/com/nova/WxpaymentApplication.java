package com.nova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WxpaymentApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WxpaymentApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WxpaymentApplication.class, args);
	}
}
