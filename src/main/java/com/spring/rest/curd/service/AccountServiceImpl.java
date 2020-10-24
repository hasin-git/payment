package com.spring.rest.curd.service;
import java.time.LocalDate;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.banking.appconstant.AppConstant;
import com.online.banking.dto.AccountRegistrationDto;
import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.LoginDto;
import com.online.banking.dto.ResponseDto;
import com.online.banking.exception.CustomizedException;
import com.online.banking.exception.EmailException;
import com.online.banking.model.AccountRegistration;
import com.online.banking.repository.AccountRegistrationRepository;
import com.online.banking.service.AccountRegistrationService;

@Service
public class AccountRegistrationServiceImpl implements AccountRegistrationService {

	@Autowired
	AccountRegistrationRepository accountRegistrationRepository;

	@Override
	public AccountResponse saveAccount(AccountRegistrationDto accountRegistrationDto) {
		if (accountRegistrationDto.getAccountName().isEmpty() || accountRegistrationDto.getEmail().isEmpty()
				|| accountRegistrationDto.getPassword().isEmpty() || accountRegistrationDto.getAccountStatus().isEmpty()
				|| accountRegistrationDto.getAccountType().isEmpty() || accountRegistrationDto.getBranch().isEmpty()
				|| accountRegistrationDto.getIfscCode().isEmpty()) {
			throw new CustomizedException(AppConstant.DETAILS_REQUIRED);
		}

		int customerId = (int) (Math.random() * 100000) + 1;

		AccountRegistration account = new AccountRegistration();
		account.setAccountNumber(customerId);
		account.setCreatedDate(LocalDate.now().toString());
		BeanUtils.copyProperties(accountRegistrationDto, account);
		accountRegistrationRepository.save(account);
		return new AccountResponse(AppConstant.SUCCESSFULLY_SAVED_DATA, AppConstant.REGISTER_SUCCESS);
	}

	public ResponseDto loginUser(LoginDto loginDto) {
		ResponseDto responseDto = new ResponseDto();
		if (loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty()) { // throw new
			LoginException(AppConstant.DETAILS_REQUIRED);
		} else {
			if (!validateEmail(loginDto.getEmail())) {
				throw new EmailException(AppConstant.INVALID_EMAIL);
			}
			responseDto = authenticateUser(loginDto.getEmail(), loginDto.getPassword());
		}
		return responseDto;
	}

	public ResponseDto authenticateUser(String email, String password) {
  ResponseDto responseDto = new ResponseDto();
  
  Optional<AccountRegistration> account =
  accountRegistrationRepository.findByEmail(email); 
  //.orElseThrow(() -> new
  LoginException(AppConstant.EMAIL_NOT_FOUND));
  //if(!account.getPassword().equals(password)) { 
  // throw new
  LoginException(AppConstant.INVALID_PASSWORD); 
  //} if(account !=null) {
  responseDto.setStatusCode(AppConstant.LOGIN_SUCCESS);
  responseDto.setMessage(AppConstant.LOGIN_SUCCESSFUL);
  responseDto.setAccountName(account.getAccountName());
  responseDto.setAccountNo(account.getAccountNumber());
  responseDto.setAccountType(account.getAccountType());
  responseDto.setBranch(account.getBranch());
  responseDto.setIfscCode(account.getIfscCode()); 
  }

	return responseDto;

	}

	public boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(AppConstant.EMAIL_PATTERN);
		return pattern.matcher(email).matches();
	}
}
