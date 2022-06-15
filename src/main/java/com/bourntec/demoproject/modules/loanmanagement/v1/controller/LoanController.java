package com.bourntec.demoproject.modules.loanmanagement.v1.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.demoproject.modules.loanmanagement.v1.requestDTO.LoanRequestDTO;
import com.bourntec.demoproject.modules.loanmanagement.v1.responseDTO.LoanResponseDTO;
import com.bourntec.demoproject.modules.loanmanagement.v1.service.LoanService;

/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

@RestController
@RequestMapping("/loan")
public class LoanController {
	
@Autowired
LoanService loanService;



/**
 * 
 * @param loanId
 * @return
 * @throws Exception
 */

@GetMapping("/{loanId}")
public LoanResponseDTO findByLoanId(@PathVariable Integer loanId )throws Exception
{
	return loanService.findByLoanId(loanId);
}

/**
 * 
 * @param loanId
 * @return
 */

@DeleteMapping("/{loanId}")
public LoanResponseDTO delete(@PathVariable Integer loanId)
{
	return loanService.deleteByLoanId(loanId);
}


/**
 * 
 * @param loanRequestDTO
 * @return
 */

@PostMapping
public LoanResponseDTO create(@RequestBody @Valid LoanRequestDTO loanRequestDTO)
{
return loanService.save(loanRequestDTO);
}

/**
 * 
 * @param loanId
 * @param loanRequestDTO
 * @return
 * @throws Exception
 */

@PutMapping("/{loanId}")
public LoanResponseDTO updateByLoanId(@PathVariable Integer loanId, @RequestBody LoanRequestDTO loanRequestDTO) throws Exception
{
loanRequestDTO.setLoanId(loanId);
return loanService.updateByLoanId(loanId,loanRequestDTO);
}

}
