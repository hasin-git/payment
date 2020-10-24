package com.spring.rest.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.online.banking.model.AccountRegistration;

@Repository
public interface AccountRegistrationRepository extends JpaRepository<AccountRegistration, Long> {
	
	Optional<AccountRegistration> findByAccountNumber(long accountNo);
	
	Optional<AccountRegistration> findByEmail(String email);
	
	Optional<AccountRegistration> findByEmailAndPassword(String email, String password);

}