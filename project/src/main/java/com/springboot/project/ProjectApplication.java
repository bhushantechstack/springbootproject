package com.springboot.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		System.out.println("this is test");
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Bean
	 public WebClient webClient() {
		return WebClient.builder().baseUrl("http://localhost:8082/thirdparty/suppliers").build();
		}
}
