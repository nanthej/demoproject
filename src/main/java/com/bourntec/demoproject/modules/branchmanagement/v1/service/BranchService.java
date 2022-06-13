package com.bourntec.demoproject.modules.branchmanagement.v1.service;

import java.util.List;

import com.bourntec.demoproject.entity.Branch;
import com.bourntec.demoproject.modules.branchmanagement.v1.request.BranchRequestDTO;
import com.bourntec.demoproject.modules.branchmanagement.v1.response.BranchResponseDTO;

public interface BranchService {
	
//	public List<BranchResponseDTO> getAll();


	BranchResponseDTO save(BranchRequestDTO branchRequestDTO);
//	List<BranchRequestDTO> findByName(String branchName);

	BranchResponseDTO deleteById(Integer ifsc);

	BranchResponseDTO findById(Integer ifsc);

	BranchResponseDTO updateById(Integer ifsc, BranchRequestDTO branchRequestDTO);
	
	
}
