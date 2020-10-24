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
import com.online.banking.dto.FundTransferDto;
import com.online.banking.model.AccountTransaction;
import com.online.banking.service.AccountTransactionService;

@RestController
public class AccountTransactionController {

	@Autowired
	AccountTransactionService accountTransactionService;
	
	@PostMapping("/transfer")
	public ResponseEntity<AccountResponse> fundTransfer(@RequestBody FundTransferDto fundTransferDto) {
		return new ResponseEntity<>(accountTransactionService.fundTransfer(fundTransferDto), HttpStatus.OK);
	}
	
	@PostMapping("/transfer/{accountNo}/{amount}")
	public ResponseEntity<AccountResponse> depositAmount(@PathVariable Long accountNo, @PathVariable double amount) {
		return new ResponseEntity<>(accountTransactionService.depositAmount(accountNo, amount), HttpStatus.OK);
	}
	
	@GetMapping("/transfer/{accountNo}")
	public List<AccountTransaction> getTranactionDetails(@PathVariable Long accountNo) {
		return accountTransactionService.getTransactionDetails(accountNo);
	}
}
