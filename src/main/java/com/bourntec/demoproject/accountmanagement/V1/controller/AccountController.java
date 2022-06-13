package com.bourntec.demoproject.accountmanagement.V1.controller;

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

import com.bourntec.demoproject.accountmanagement.V1.request.AccountRequestDTO;
import com.bourntec.demoproject.accountmanagement.V1.response.AccountResponseDTO;
import com.bourntec.demoproject.accountmanagement.V1.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;


//	@GetMapping()
//	public List<AccountResponseDTO> getAll() {
//		return accountService.getAll();
//	}
	@GetMapping("/{id}")
	public AccountResponseDTO findById(@PathVariable Integer id) throws Exception {
		return accountService.findById(id);

	}

	@DeleteMapping("/{acctId}")
	public AccountResponseDTO delete(@PathVariable Integer acctId) {
		return accountService.deleteById(acctId);
	}

	@PostMapping("/new")
	public AccountResponseDTO create(@RequestBody @Valid AccountRequestDTO accountRequestDTO) {
		return accountService.save(accountRequestDTO);
	}

	@GetMapping("/neww")
	public String getMessage() {
		return "hello";

	}
	@PutMapping("/{acctId}")
	public AccountResponseDTO updateById(@PathVariable Integer acctId,
	@RequestBody AccountRequestDTO accountRequestDTO) throws Exception {
	return accountService.updateById(acctId, accountRequestDTO);
	}

}