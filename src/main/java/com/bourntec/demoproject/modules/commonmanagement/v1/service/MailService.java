package com.bourntec.demoproject.modules.commonmanagement.v1.service;

import com.bourntec.demoproject.modules.commonmanagement.v1.request.EmailRequestDTO;

public interface MailService {
	String sendSimpleMail(EmailRequestDTO details);

}
