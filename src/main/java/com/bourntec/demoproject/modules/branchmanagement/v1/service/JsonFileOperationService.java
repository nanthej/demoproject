package com.bourntec.demoproject.modules.branchmanagement.v1.service;

import java.util.List;

import com.bourntec.demoproject.modules.branchmanagement.v1.response.BranchResponseDTO;



public interface JsonFileOperationService {
	void write(List<BranchResponseDTO> list, String fileName);

}
