package com.bourntec.demoproject.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="loan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/**
 * 
 * @author P H NANDU KRISHNA
 *
 */
public class Loan {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanId;
	private Double amount;
	private Integer custId;
	private Double interest;
	private LocalDate date;
	
		
	
	
		
		
	
	
	

}
