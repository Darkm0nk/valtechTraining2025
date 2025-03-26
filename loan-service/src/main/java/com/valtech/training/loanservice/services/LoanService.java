package com.valtech.training.loanservice.services;

import java.util.List;

import com.valtech.training.loanservice.Loan;

public interface LoanService {

	Loan createLoan(Loan loan);

	Loan getLoan(long id);

	void deleteLoan(long id);

	List<Loan> getAllLoan();

	Loan processLoan(Loan loan);

}