package com.bourntec.demoproject.modules.branchmanagement.v1.response;



import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.bourntec.demoproject.entity.Branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchResponseDTO {
	String responeMessege;
	Object payLoad;
	String status;
	
	public BranchResponseDTO(Branch branch) {
		BeanUtils.copyProperties(branch,this);
	}





	

}
