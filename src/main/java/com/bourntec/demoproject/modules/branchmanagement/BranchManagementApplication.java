package com.bourntec.demoproject.modules.branchmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.bourntec.demoproject")

public class BranchManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(BranchManagementApplication.class, args);
	}


}
