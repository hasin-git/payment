package com.spring.rest.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.BeneficiaryAccountDto;
import com.online.banking.dto.BeneficiaryDto;
import com.online.banking.service.BeneficiaryAccountService;

@RestController
public class BenificiaryAccountController {

	@Autowired
	BeneficiaryAccountService service;
	
	@PostMapping("/beneficiary")
	public ResponseEntity<AccountResponse> saveBeneficiary(@RequestBody BeneficiaryAccountDto beneficiaryAccountDto) {
		return new ResponseEntity<>(service.saveBeneficiary(beneficiaryAccountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/beneficiary/{accountNo}")
	public ResponseEntity<List<BeneficiaryDto>> getBeneficiaryDetailsByaccountNo(@PathVariable Long accountNo) {
		return new ResponseEntity<>(service.getBeneficiaryDetailsByAcctNo(accountNo), HttpStatus.OK);
	}
	
}