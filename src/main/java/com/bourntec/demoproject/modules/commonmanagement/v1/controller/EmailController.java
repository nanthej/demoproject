package com.bourntec.demoproject.modules.commonmanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.demoproject.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.demoproject.modules.commonmanagement.v1.service.MailService;

@RestController
public class EmailController {

	@Autowired
	private MailService emailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailRequestDTO details) {
		String status = emailService.sendSimpleMail(details);
		return status;
	}
}
