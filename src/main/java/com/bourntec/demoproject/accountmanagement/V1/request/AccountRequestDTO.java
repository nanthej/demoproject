package com.bourntec.demoproject.accountmanagement.V1.request;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.bourntec.demoproject.entity.Account;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {
	
	private Integer acctId;
	private Integer acctNumber;
	private Integer custId;
	private double balance;
	String loanType;
	LocalDate date;
	private String status;


public 	Account convertToModel() {
	Account account=new Account();
	BeanUtils.copyProperties(this, account);
	return account;
}
}
