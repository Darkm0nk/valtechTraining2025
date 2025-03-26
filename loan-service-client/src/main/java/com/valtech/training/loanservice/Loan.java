package com.valtech.training.loanservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq", sequenceName = "loan_seq", allocationSize = 1)
	private long id;
	private String username;
	private long salary;
	private int cibilScore;
	private long loanAmount;
	private LoanType loanType;
	private LoanStatus loanStatus;
	private String assets;
	private long assetValue;
	
	public enum LoanType{
		CAR, GOLD, HOME
	}
	
	public enum LoanStatus{
		APLLIED, PENDING, IN_PROCESS, APPROVED, REJECTED
	}
	
	
	public Loan() {
		
	}

	
	
	public Loan(String username, long salary, int cibilScore, long loanAmount, LoanType loanType, LoanStatus loanStatus, String assets, long assetValue) {
		this.username= username;
		this.salary = salary;
		this.cibilScore = cibilScore;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanStatus = loanStatus;
		this.assets = assets;
		this.assetValue = assetValue;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		salary = salary;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public LoanType getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public long getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(long assetValue) {
		this.assetValue = assetValue;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	
}
