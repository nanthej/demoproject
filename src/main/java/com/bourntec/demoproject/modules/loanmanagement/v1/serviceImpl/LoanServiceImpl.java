package com.bourntec.demoproject.modules.loanmanagement.v1.serviceImpl;



import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bourntec.demoproject.entity.Loan;
import com.bourntec.demoproject.modules.loanmanagement.v1.repository.LoanRepository;
import com.bourntec.demoproject.modules.loanmanagement.v1.requestDTO.LoanRequestDTO;
import com.bourntec.demoproject.modules.loanmanagement.v1.responseDTO.LoanResponseDTO;
import com.bourntec.demoproject.modules.loanmanagement.v1.service.LoanService;

/**
 * 
 * @author P H NANDU KRISHNA
 *
 */

@Service
public class LoanServiceImpl implements LoanService {
	
 Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	@Autowired
	LoanRepository loanRepository;
	
	/**
	 * @Param loanId
	 * @throws Exception
	 */
	
	@Override
	public LoanResponseDTO findByLoanId(Integer loanId) throws Exception {

		LoanResponseDTO loanResponseDTO = new LoanResponseDTO();
		Optional<Loan> loanOptional = loanRepository.findById(loanId);
		if (loanOptional.isPresent()) 
		{

			loanResponseDTO.setPayload(loanOptional.get());
			loanResponseDTO.setResponseMessage(" data got sucessfully");
			logger.info("Successfully fetched");
			loanResponseDTO.setStatus("Sucess");
			return loanResponseDTO;
		} 
		else 
		{
			loanResponseDTO.setResponseMessage(" Given id does not exists");
			logger.error("User Not Found");
			loanResponseDTO.setStatus("failed");
			return loanResponseDTO;
		}
	}
	
	/**
	 * @Param loanId
	 */
	
	@Override
	public LoanResponseDTO deleteByLoanId(Integer loanId) {
		LoanResponseDTO loanResponseDTO = new LoanResponseDTO();
		if (loanRepository.existsById(loanId) == true)
		{
			loanRepository.deleteById(loanId);
			loanResponseDTO.setResponseMessage("Deleted successfully");
			loanResponseDTO.setStatus("Success");
			logger.info("deleted");
			return loanResponseDTO;
		} 
		else
		{
			loanResponseDTO.setResponseMessage("Data not found");
			logger.error("User Not Found");
			loanResponseDTO.setStatus("Failed");
			return loanResponseDTO;
		}
	
	}
	
	/**
	 * @param loanRequestDTO
	 */
	@Override
	public LoanResponseDTO save(LoanRequestDTO loanRequestDTO){
		
		Loan loan=loanRequestDTO.convertToModel();
		LoanResponseDTO LoanResponseDTO=new LoanResponseDTO(loan);
		//loan.setStatus(Constants.CONFIRM);
		loan=loanRepository.save(loan);
		LoanResponseDTO.setPayload(loan);
		LoanResponseDTO.setResponseMessage("Payment data saved sucessfully");
		logger.info("data saved successfully");
		LoanResponseDTO.setStatus("Success");
		return LoanResponseDTO;
		
	}
	

	/**
	 * @param loanId,loanRequestDTO
	 */

	@Override
	public LoanResponseDTO updateByLoanId(Integer loanId, LoanRequestDTO loanRequestDTO){
		
		LoanResponseDTO loanResponseDTO = new LoanResponseDTO();
	    Optional<Loan> loanOptional = loanRepository.findByLoanId(loanId);
	    if (loanOptional.isPresent()) 
	    {

		   Loan loan = loanRequestDTO.convertToModel();
		   loan.setLoanId(loanId);
	       loan=loanRepository.save(loan);
	       loanResponseDTO.setPayload(loan);
	       loanResponseDTO.setResponseMessage(" data saved sucessfully");
	       logger.info("data updated");
	       loanResponseDTO.setStatus("Success");
	       return loanResponseDTO;
	   
	    } 
	    else
	    {

	    	loanResponseDTO.setResponseMessage(" id not present");
	    	logger.error("User Not Found");
	    	loanResponseDTO.setStatus("failed");
	    	return loanResponseDTO;

	    }

	}


	
}