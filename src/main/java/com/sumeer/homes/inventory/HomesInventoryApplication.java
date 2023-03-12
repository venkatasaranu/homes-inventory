package com.sumeer.homes.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HomesInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomesInventoryApplication.class, args);
	}

//	@Bean
//	WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/inventory/excel")
//						.allowedOrigins("http://localhost:4200");
//			}
//		};
//	}

}
