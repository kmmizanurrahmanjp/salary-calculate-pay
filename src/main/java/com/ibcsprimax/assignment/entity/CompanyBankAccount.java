package com.ibcsprimax.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Entity
public class CompanyBankAccount implements Serializable{

	private static final long serialVersionUID = -4144524509667435076L;
	
	@Id
	@SequenceGenerator(name = "accountSeqGen", sequenceName = "accountSeq", initialValue = 2000000000, allocationSize = 1)
    @GeneratedValue(generator = "accountSeqGen")
	@Column(name="account_no")
	private int companyAccountNo;
	
	@Column(name="account_name", nullable= false)
	private String accountName;
	
	private String accountType;
	
	@Column(name="balence", nullable= false)
	private int balence;
	
	@Column(name="paid_amount", nullable= false)
	private int totalPaidAmount;
	
	private String bankName;
	
	private String branchName;
	

	public int getCompanyAccountNo() {
		return companyAccountNo;
	}

	public void setCompanyAccountNo(int companyAccountNo) {
		this.companyAccountNo = companyAccountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getBalence() {
		return balence;
	}

	public void setBalence(int balence) {
		this.balence = balence;
	}

	public int getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(int totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	

	
	
}
