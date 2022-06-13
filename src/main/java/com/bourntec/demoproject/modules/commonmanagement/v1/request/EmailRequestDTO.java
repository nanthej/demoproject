package com.bourntec.demoproject.modules.commonmanagement.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDTO {

	private String toMail;
	private String subject;
	private String message;
	private String module;
	private String keyValue;

}
