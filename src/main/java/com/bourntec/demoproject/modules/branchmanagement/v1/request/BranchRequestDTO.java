package com.bourntec.demoproject.modules.branchmanagement.v1.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.demoproject.entity.Branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BranchRequestDTO {
	
	String branchName;
	String place;
	Integer zipCode;
	Long phoneNum;
	
public Branch ConvertToModel() {
	Branch branch=new Branch();
	BeanUtils.copyProperties(this, branch);
	return branch;
}
	

}
