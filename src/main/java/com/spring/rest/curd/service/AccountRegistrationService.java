package com.spring.rest.curd.service;
import com.online.banking.dto.AccountRegistrationDto;
import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.LoginDto;
import com.online.banking.dto.ResponseDto;

public interface AccountRegistrationService {
	
	public AccountResponse saveAccount(AccountRegistrationDto account);
	
	public ResponseDto loginUser(LoginDto loginDto);

}
