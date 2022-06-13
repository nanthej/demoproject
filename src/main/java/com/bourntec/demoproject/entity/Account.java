package com.bourntec.demoproject.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acctId;
	private Integer acctNumber;
	private Integer custId;
	private double balance;
	private String loanType;
	LocalDate date;
	private String status;

}
