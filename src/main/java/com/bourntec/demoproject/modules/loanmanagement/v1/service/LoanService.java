package com.bourntec.demoproject.modules.loanmanagement.v1.service;


import com.bourntec.demoproject.modules.loanmanagement.v1.requestDTO.LoanRequestDTO;
import com.bourntec.demoproject.modules.loanmanagement.v1.responseDTO.LoanResponseDTO;

/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

public interface LoanService {
	
	
public LoanResponseDTO deleteByLoanId(Integer loanId);	

LoanResponseDTO save(LoanRequestDTO loanRequestDTO);

public LoanResponseDTO updateByLoanId(Integer loanId, LoanRequestDTO loanRequestDTO) ;

LoanResponseDTO findByLoanId(Integer loanId) throws Exception;


}
