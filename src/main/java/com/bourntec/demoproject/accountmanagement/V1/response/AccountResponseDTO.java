package com.bourntec.demoproject.accountmanagement.V1.response;

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
public class AccountResponseDTO {
	String responeMessege;
	Object payLoad;
	String status;

	public AccountResponseDTO(Account account) {
	BeanUtils.copyProperties(account,this);
	}



}