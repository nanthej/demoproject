package com.bourntec.demoproject.accountmanagement.V1.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.demoproject.accountmanagement.V1.request.AccountRequestDTO;
import com.bourntec.demoproject.accountmanagement.V1.response.AccountResponseDTO;
import com.bourntec.demoproject.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

	// List<AccountResponseDTO> getAll();

	AccountResponseDTO save(AccountRequestDTO accountRequestDTO);

	//String deleteByAccountId(int acctId);

}
