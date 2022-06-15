package com.bourntec.demoproject.modules.loanmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bourntec.demoproject.DemoprojectApplication;

@EntityScan("com.bourntec.demoproject")
@EnableJpaRepositories
@SpringBootApplication
public class LoanManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojectApplication.class, args);

	}

}
