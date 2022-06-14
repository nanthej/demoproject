
package com.bourntec.demoproject.modules.commonmanagement.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bourntec.demoproject.accountmanagement.V1.response.AccountResponseDTO;
import com.bourntec.demoproject.accountmanagement.V1.util.Constants;
import com.bourntec.demoproject.entity.Account;
import com.bourntec.demoproject.entity.Branch;
//import com.bourntec.demoproject.modules.branchmanagement.v1.util;
import com.bourntec.demoproject.modules.branchmanagement.v1.response.BranchResponseDTO;
import com.bourntec.demoproject.modules.commonmanagement.v1.request.EmailRequestDTO;
import com.bourntec.demoproject.modules.commonmanagement.v1.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
* @author Praveena Prasannakumar
*
**/
@Service
@RequestMapping("/branches")
public class EmailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(EmailRequestDTO details) {
		RestTemplate restTemplate = new RestTemplate();
		Branch branch = new Branch();
		//Account account=new Account();

		final ObjectMapper mapper = new ObjectMapper();
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getToMail());
			mailMessage.setSubject(details.getSubject());
			if (details.getModule().equalsIgnoreCase(Constants.BRANCH)) {
				BranchResponseDTO branresdto = restTemplate.getForObject(
						"http://localhost:8080/branches"
						+ "/" + details.getKeyValue(), BranchResponseDTO.class);

				branch = mapper.convertValue(branresdto.getPayLoad(), Branch.class);
				mailMessage.setText(details.getMessage() + branch.getBranchName() + branch.getPlace());
				javaMailSender.send(mailMessage);
				return "Mail Sent Successfully...";
			}
			else if (details.getModule().equalsIgnoreCase(Constants.ACCOUNT)) {
				AccountResponseDTO accountResponseDTO=restTemplate.getForObject("http://localhost:8082/accounts/" + details.getKeyValue(),AccountResponseDTO.class);	
				Account account=new Account();
			account=mapper.convertValue(accountResponseDTO.getPayLoad(),Account.class);
			mailMessage.setText(details.getMessage()+ account.getBalance() + account.getLoanType());
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully..."; 
			
				 
			}
		}

		catch (Exception e) {
			return "Details not found....." + e.getMessage();
		}
		return sender;
	}
}
