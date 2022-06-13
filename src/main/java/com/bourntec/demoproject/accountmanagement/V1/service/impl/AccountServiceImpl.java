package com.bourntec.demoproject.accountmanagement.V1.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bourntec.demoproject.accountmanagement.V1.repository.AccountRepository;
import com.bourntec.demoproject.accountmanagement.V1.request.AccountRequestDTO;
import com.bourntec.demoproject.accountmanagement.V1.response.AccountResponseDTO;
import com.bourntec.demoproject.accountmanagement.V1.service.AccountService;
import com.bourntec.demoproject.accountmanagement.V1.util.Constants;
import com.bourntec.demoproject.entity.Account;

import lombok.extern.slf4j.Slf4j;

/***
 * @author Ginson Roice
 *
 **/
//@EnableRetry
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
	Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountResponseDTO findById(Integer acctId) throws Exception {
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		Optional<Account> accountOptional = accountRepository.findById(acctId);
		if (accountOptional.isPresent()) {
			accountResponseDTO.setPayLoad(accountOptional.get());
			accountResponseDTO.setResponeMessege("data got sucessfully");
			logger.info("Successfully fetched");
			accountResponseDTO.setStatus("Success");
			return accountResponseDTO;
		} else {
			accountResponseDTO.setResponeMessege("Given id does not exists");
			logger.error("User Not Found");
			accountResponseDTO.setStatus("failed");
			return accountResponseDTO;
		}
	}

	@Override
	// @Scheduled(fixedDelay = 1000 * 60 * 60)
	// @Retryable(value = {
	// Exception.class }, maxAttemptsExpression = "${retry.maxAttempts}", backoff =
	// @Backoff(delayExpression = "${retry.backOffDelay}", multiplier = 2))
	
	public AccountResponseDTO deleteById(Integer acctId) {
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		if (accountRepository.existsById(acctId) == true)
		{
			accountRepository.deleteById(acctId);
			accountResponseDTO.setResponeMessege("delete sucessfully");
			accountResponseDTO.setStatus("Success");
			logger.info("deleted");
			return accountResponseDTO;
		}
		else
		{
			accountResponseDTO.setResponeMessege("Data not found");
			logger.error("User Not Found");
			accountResponseDTO.setStatus("Failed");
			return accountResponseDTO;

		}
	}
//
//	@Recover
//	void recover(Exception e) {
//		logger.info("entering into retry()" + e.getMessage());
//		
//	}
	

//@Override
//public List<AccountResponseDTO> getAll() {
//	// TODO Auto-generated method stub
//	return accountRepository.findByStatus(Constants.ACTIVE).stream()
//			.map(AccountResponseDTO::new)
//			.collect(Collectors.toList());
//			}
//}

	@Override
	public AccountResponseDTO save(AccountRequestDTO accountRequestDTO) {
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		Account account = accountRequestDTO.convertToModel();
		account.setStatus(Constants.ACTIVE);
		account = accountRepository.save(account);
		accountResponseDTO.setPayLoad(account);
		accountResponseDTO.setResponeMessege("Payment data saved sucessfully");
		accountResponseDTO.setStatus("Success");
		return accountResponseDTO;
	}


	@Override
	public AccountResponseDTO updateById(Integer acctId, AccountRequestDTO accountRequestDTO) {
		AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
		Optional<Account> accountOptional = accountRepository.findById(acctId);
		if (accountOptional.isPresent()) {
			Account account = accountRequestDTO.convertToModel();
			account.setAcctId(acctId);
			account = accountRepository.save(account);
			accountResponseDTO.setPayLoad(account);
			accountResponseDTO.setResponeMessege(" data save sucessfully");
			logger.info("data updated");
			accountResponseDTO.setStatus("Success");
			return accountResponseDTO;
		} else
			accountResponseDTO.setResponeMessege("id not present");
		logger.error("User Not Found");
		accountResponseDTO.setStatus("failed");
		return accountResponseDTO;
	}
}
