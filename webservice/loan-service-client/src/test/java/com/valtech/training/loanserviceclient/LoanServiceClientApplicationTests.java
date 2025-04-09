package com.valtech.training.loanserviceclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.Loan.LoanStatus;
import com.valtech.training.loanservice.Loan.LoanType;
import com.valtech.training.loanservice.webservices.LoanServiceWS;

@SpringBootTest
class LoanServiceClientApplicationTests {

	@Autowired
	private LoanServiceWS loanServiceWS;
	
	@Test
	void contextLoads() {
		loanServiceWS.createLoan(new Loan("hey", 5000, 700, 100000, LoanType.CAR, LoanStatus.APLLIED, "car", 123121));
	}

}
