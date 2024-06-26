package com.zep.jobms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class JobmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobmsApplication.class, args);
		System.out.println("Jobs Software Engineer");
	}

}
