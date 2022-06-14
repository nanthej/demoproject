package com.bourntec.demoproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "branch")
@Data
@Getter
@Setter
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ifsc;
	String branchName;
	String place;
	Integer zipCode;
	Long phoneNum;
	private String Status;

//	public void setStatus(String active) {
//	}


}
