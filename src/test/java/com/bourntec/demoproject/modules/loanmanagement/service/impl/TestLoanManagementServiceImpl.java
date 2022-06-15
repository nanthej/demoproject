package com.bourntec.demoproject.modules.loanmanagement.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bourntec.demoproject.entity.Loan;
import com.bourntec.demoproject.modules.loanmanagement.v1.repository.LoanRepository;
import com.bourntec.demoproject.modules.loanmanagement.v1.serviceImpl.LoanServiceImpl;
/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

@ExtendWith(MockitoExtension.class)
class TestLoanManagementServiceImpl {

	@InjectMocks
	LoanServiceImpl loanServiceImpl;
	@Mock
	LoanRepository loanRepository;


    @Test
	public void save() {
			Loan loans= Loan.builder().
		loanId(9).amount((double) 50000).custId(109).date(LocalDate.parse("2019-04-17")).interest(0.5).build();
		
			loanRepository.save(loans);
			Assertions.assertThat(loans).isNotNull();
		   
}
	@Test
	public void  findByLoanId()
	{
			Optional<Loan> loanList = loanRepository.findByLoanId(1);
			Assertions.assertThat(loanList).isNotNull();
	}
		 
	



	
}
