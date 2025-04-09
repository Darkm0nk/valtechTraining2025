package com.valtech.training.loanservice.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.loanservice.Loan;

@WebService
public interface LoanServiceWS {

	Loan processLoan(Loan loan);

	List<Loan> getAllLoan();

	void deleteLoan(long id);

	Loan getLoan(long id);

	Loan createLoan(Loan loan);

}