package com.bourntec.demoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class DemoprojectApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoprojectApplication.class, args);
	}

	

}
