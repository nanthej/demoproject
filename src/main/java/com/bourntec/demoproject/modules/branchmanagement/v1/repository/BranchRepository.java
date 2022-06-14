package com.bourntec.demoproject.modules.branchmanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.stereotype.Repository;

import com.bourntec.demoproject.entity.Branch;
import com.bourntec.demoproject.modules.branchmanagement.v1.request.BranchRequestDTO;


@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>, JpaSpecificationExecutor<BranchRequestDTO> {

	
//	List<BranchRequestDTO> findByName(String name);
//
//	Branch save(Branch branch);
//	List<Branch> findByRecordStatus(String recordStatus);
//
//	Branch findByIfscAndRecordStatus(int ifsc, String recordStatus);
//	List<BranchResponseDTO> getAll();
//

//
//	//void save(Integer ifsc);
	
	//BranchResponseDTO save(BranchRequestDTO branchRequestDTO);
	
	Optional<Branch> findById(Integer ifsc); //responsedto



}
