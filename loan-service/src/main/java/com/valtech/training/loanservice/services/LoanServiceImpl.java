package com.valtech.training.loanservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.Loan.LoanStatus;
import com.valtech.training.loanservice.repos.LoanRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public Loan createLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	
	@Override
	public Loan getLoan(long id) {
		return loanRepo.getReferenceById(id);
	}
	
	@Override
	public void deleteLoan(long id) {
		loanRepo.deleteById(id);
	}
	
	@Override
	public List<Loan> getAllLoan(){
		return loanRepo.findAll();
	}
	
	@Override
	public Loan processLoan(Loan loan) {
		int cibilScore = loan.getCibilScore();
		long assetValue = loan.getAssetValue();
		long loanAmount = loan.getLoanAmount();
		long salary = loan.getSalary();
		LoanStatus loanStatus;
		if(cibilScore < 600) {
			loan.setLoanStatus(LoanStatus.REJECTED);
			return loan;
		}else if(cibilScore< 800) {
			if(assetValue >= loanAmount * 0.7 && salary * 5 >= loanAmount) {
				loan.setLoanStatus(LoanStatus.APPROVED);
				return loan;
			}
			else {
				loan.setLoanStatus(LoanStatus.REJECTED);
				return loan;
			}
		}else {
			if(assetValue >= loanAmount * 0.6 && salary * 4 >= loanAmount) {
				loan.setLoanStatus(LoanStatus.APPROVED);
				return loan;
			}
			else {
				loan.setLoanStatus(LoanStatus.REJECTED);
				return loan;
			}
		}
	}
}
