package com.spring.rest.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.online.banking.model.BeneficiaryAccount;

@Repository
public interface BeneficiaryAccountRepository extends JpaRepository<BeneficiaryAccount, Long> {
	
	Optional<BeneficiaryAccount> findByPayeeAccountNo(Long accNo);

}