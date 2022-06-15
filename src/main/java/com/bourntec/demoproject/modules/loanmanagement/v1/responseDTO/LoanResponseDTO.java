package com.bourntec.demoproject.modules.loanmanagement.v1.responseDTO;

import org.springframework.beans.BeanUtils;

import com.bourntec.demoproject.entity.Loan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO{

	String responseMessage;
	Object payload;
	String status;
	
	/**
	 * 
	 * @param loan
	 */
	
	public LoanResponseDTO(Loan loan) 
	{
		BeanUtils.copyProperties(loan, this);
	}



	
}
