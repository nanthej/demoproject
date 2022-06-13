package com.bourntec.demoproject.accountmanagement.V1.excpetion;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException
{
String errorMessage;
}
