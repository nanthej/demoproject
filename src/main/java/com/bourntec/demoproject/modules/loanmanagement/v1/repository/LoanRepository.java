package com.bourntec.demoproject.modules.loanmanagement.v1.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.bourntec.demoproject.entity.Loan;

/**
 * 
 * @author P H NANDU KRISHNA
 *
 */
public interface LoanRepository extends JpaRepository<Loan,Integer>,JpaSpecificationExecutor<Loan> {

	Optional<Loan> findByLoanId(Integer loanId);


	
}
