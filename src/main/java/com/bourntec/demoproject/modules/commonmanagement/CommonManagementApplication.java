package com.bourntec.demoproject.modules.commonmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.bourntec.demoproject.entity")
@ComponentScan({ "com.bourntec.demoproject.modules.commonmanagement", "com.bourntec.demoproject.utility" })
public class CommonManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(CommonManagementApplication.class, args);

	}
}
