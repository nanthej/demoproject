package com.bourntec.demoproject.modules.branchmanagement.v1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.demoproject.modules.branchmanagement.v1.request.BranchRequestDTO;
import com.bourntec.demoproject.modules.branchmanagement.v1.response.BranchResponseDTO;
import com.bourntec.demoproject.modules.branchmanagement.v1.service.BranchService;

@RestController
@RequestMapping("/branches")
public class BranchController	 {
	@Autowired
	BranchService branchService;
//
//	@GetMapping()
//	public List<BranchResponseDTO> getAll() {
//	return branchservice.getAll();
//	}
	@GetMapping("/{ifsc}")
	public BranchResponseDTO findById(@PathVariable Integer ifsc) throws Exception {
	return branchService.findById(ifsc);

	}
	@PutMapping("/{ifsc}")
	public BranchResponseDTO updateById(@PathVariable Integer ifsc,
	@RequestBody BranchRequestDTO branchRequestDTO) throws Exception {
	return branchService.updateById(ifsc, branchRequestDTO);
	}


	@PostMapping
	public BranchResponseDTO create(@RequestBody BranchRequestDTO branchRequestDTO)
	{
	return branchService.save(branchRequestDTO);
	}
	
	@DeleteMapping("/{ifsc}")
	public BranchResponseDTO deleteById(@PathVariable int ifsc) {
	return branchService.deleteById(ifsc);



	}
	
	
	
	
	
	
}
