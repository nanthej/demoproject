package com.bourntec.demoproject.accountmanagement.V1.service;

import com.bourntec.demoproject.accountmanagement.V1.request.AccountRequestDTO;
import com.bourntec.demoproject.accountmanagement.V1.response.AccountResponseDTO;
//import com.bourntec.demoproject.accountmanagement.V1.service.impl.List;

public interface AccountService {

	AccountResponseDTO save(AccountRequestDTO accountRequestDTO);

	public AccountResponseDTO findById(Integer acctId) throws Exception;

	AccountResponseDTO deleteById(Integer acctId);

	AccountResponseDTO updateById(Integer acctId, AccountRequestDTO accountRequestDTO);
//public List<AccountResponseDTO> getAll() {

	
}

