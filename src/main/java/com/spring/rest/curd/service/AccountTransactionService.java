package com.spring.rest.curd.service;
import java.util.List;

import com.online.banking.dto.AccountResponse;
import com.online.banking.dto.FundTransferDto;
import com.online.banking.model.AccountTransaction;

public interface AccountTransactionService {
	
	AccountResponse fundTransfer(FundTransferDto fundDto);
	
	List<AccountTransaction> getTransactionDetails(long accountNo);
	
	AccountResponse depositAmount(long accountNo, double amount);

}
