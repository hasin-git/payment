package com.spring.rest.curd.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.banking.dto.AccountRegistrationDto;
import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.LoginDto;
import com.online.banking.dto.ResponseDto;
import com.online.banking.service.AccountRegistrationService;

@RestController
public class AccountRegistrationController {
	
	@Autowired
	AccountRegistrationService accountRegistrationService;
	
	@PostMapping("/accounts")
	public ResponseEntity<AccountResponse> saveAccount(@RequestBody AccountRegistrationDto accountRegistrationDto) {
		return new ResponseEntity<>(accountRegistrationService.saveAccount(accountRegistrationDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> userLogin(@RequestBody LoginDto loginDto) throws LoginException {
		return new ResponseEntity<>(accountRegistrationService.loginUser(loginDto), HttpStatus.OK);
	}
}
