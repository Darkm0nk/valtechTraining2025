package com.valtech.training.loanservice.webservices;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.services.LoanService;

@WebService(endpointInterface = "com.valtech.training.loanservice.webservices.LoanServiceWS", name = "LoanService", portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS {
	
	@Autowired
	private LoanService loanService;
	
	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService = loanService;
	}
			
	
	@Override
	public Loan createLoan(Loan loan) {
		return loanService.createLoan(loan);
	}

	@Override
	public Loan getLoan(long id) {
		return loanService.getLoan(id);
	}

	@Override
	public void deleteLoan(long id) {
		 loanService.deleteLoan(id);
	}

	@Override
	public List<Loan> getAllLoan(){
		return loanService.getAllLoan();
	}

	@Override
	public Loan processLoan(Loan loan) {
		return loanService.processLoan(loan);
	}
}
