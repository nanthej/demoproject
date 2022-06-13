package com.bourntec.demoproject.modules.branchmanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.demoproject.entity.Branch;
import com.bourntec.demoproject.modules.branchmanagement.v1.repository.BranchRepository;
import com.bourntec.demoproject.modules.branchmanagement.v1.request.BranchRequestDTO;
import com.bourntec.demoproject.modules.branchmanagement.v1.response.BranchResponseDTO;
import com.bourntec.demoproject.modules.branchmanagement.v1.service.BranchService;
import com.bourntec.demoproject.modules.branchmanagement.v1.util.Constants;
/***
* @author Praveena Prasannakumar
*
**/
@Service
public class BranchServiceImpl implements BranchService {
	Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

	@Autowired
	BranchRepository branchRepository;

//	@Override
//	public List<BranchRequestDTO> findByName(String branchName) {
//
//		return branchRepository.findByName(branchName);
//	}
//
//	@Override
//	public List<BranchResponseDTO> getAll() {
//		// TODO Auto-generated method stub
//		return branchRepository.getAll();
//	}
//
	@Override
	public BranchResponseDTO findById(Integer ifsc) {

		BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
		Optional<Branch> branchOptional = branchRepository.findById(ifsc);
		if (branchOptional.isPresent()) {

			branchResponseDTO.setPayLoad(branchOptional.get());
			branchResponseDTO.setResponeMessege(" data got sucessfully");
			logger.info("Successfully fetched");
			branchResponseDTO.setStatus("Sucess");
			return branchResponseDTO;
		} else {
			branchResponseDTO.setResponeMessege(" Given id does not exists");
			logger.error("User Not Found");
			branchResponseDTO.setStatus("failed");
			return branchResponseDTO;
		}
	}

	@Override
	public BranchResponseDTO save(BranchRequestDTO branchRequestDTO) {

		Branch branch = branchRequestDTO.ConvertToModel();
		BranchResponseDTO branchResponseDTO = new BranchResponseDTO(branch);
		branch.setStatus(Constants.ACTIVE);
		branch = branchRepository.save(branch);
		branchResponseDTO.setPayLoad(branch);
		branchResponseDTO.setResponeMessege("Branch created sucessfully");
		logger.info("data saved successfully");
		branchResponseDTO.setStatus("Success");
		return branchResponseDTO;
	}

	@Override
	public BranchResponseDTO deleteById(Integer ifsc) {
		BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
		if (branchRepository.existsById(ifsc) == true) {
			branchRepository.deleteById(ifsc);
			branchResponseDTO.setResponeMessege("Deleted successfully");
			branchResponseDTO.setStatus("Sucess");
		logger.info("deleted");
		return branchResponseDTO;
		} else
			branchResponseDTO.setResponeMessege("Data not found");
		logger.error("User Not Found");
		return branchResponseDTO;
	}
	
	@Override
	public BranchResponseDTO updateById(Integer ifsc, BranchRequestDTO branchRequestDTO) {
		BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
	Optional<Branch> branchOptional = branchRepository.findById(ifsc);
	if (branchOptional.isPresent()) {

	Branch branch = branchRequestDTO.ConvertToModel();
	//Branch existingbranch = branchOptional.get();
	
	branch.setIfsc(ifsc);
	branch=branchRepository.save(branch);
	branchResponseDTO.setPayLoad(branch);
	branchResponseDTO.setResponeMessege(" data save sucessfully");
	logger.info("data updated");
	branchResponseDTO.setStatus("Sucess");
	return branchResponseDTO;
	} else
		branchResponseDTO.setResponeMessege(" id not present");
	logger.error("User Not Found");
	branchResponseDTO.setStatus("failed");
	return branchResponseDTO;



	}

}
