package com.spring.rest.curd.service;

import java.util.List;

import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.BeneficiaryAccountDto;
import com.online.banking.dto.BeneficiaryDto;

public interface BeneficiaryAccountService {

	AccountResponse saveBeneficiary(BeneficiaryAccountDto beneficiaryAccountDto);
	
	BeneficiaryDto getBeneficiaryDetailsByAcctNo(Long accountNo);
}
