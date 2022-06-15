package com.bourntec.demoproject.modules.loanmanagement.v1.requestDTO;


import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.bourntec.demoproject.entity.Loan;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

@Data
@AllArgsConstructor

public class LoanRequestDTO {
	
	
	 Integer loanId;
	
	 @NotNull(message="Amount cannot be below 5000")
	 @Min(5000)
	 Double amount;
	 
      Integer custId;
	 
	 @NotNull(message="Interest cannot be below 0.3")
	 @Min((long) 0.3)
	 Double interest;
	 
	 @NotNull(message="Date cannot be empty")
	 LocalDate date;
	 
	 
public Loan convertToModel() {
	
	Loan loan=new Loan();
	
	BeanUtils.copyProperties(this, loan);
	
	return loan;
}


/*
public static String[] getNullPropertyNames (Object source) {
	final BeanWrapper src =  new BeanWrapperImpl(source);
	java.beans.PropertyDescriptor[] pds =src.getPropertyDescriptors();
	
	Set<String> emptyNames = new HashSet<>();
	for(java.beans.PropertyDescriptor pd : pds) {
		Object srcValue = src.getPropertyValue(pd.getName());
		if(srcValue == null) emptyNames.add(pd.getName());
	}
	
	 String[] result = new String[emptyNames.size()];
	 return emptyNames.toArray(result);
			 
	
}
		
*/
	
}
