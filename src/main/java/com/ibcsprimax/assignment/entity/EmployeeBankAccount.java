 package com.ibcsprimax.assignment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Entity
public class EmployeeBankAccount implements Serializable{


	private static final long serialVersionUID = -2605292523776018688L;
	
	@Id
	@SequenceGenerator(name = "accountSeqGen", sequenceName = "accountSeq", initialValue = 1000000000, allocationSize = 1)
    @GeneratedValue(generator = "accountSeqGen")
	@Column(name="account_no")
	private int employeeAccountNo;
	
	@Column(name="account_name", nullable= false)
	private String accountName;
	
	@Column(name="account_type_id", nullable= false)
	private int accountTypeId;
	
	@Transient
	private String accountTypeName;
	
	@Column(name="balence", nullable= true)
	private int balence;
	
	@Column(name="salary_flag", nullable= true)
	private int salaryFlag;
	
	@Column(name="bank_id", nullable= false)
	private int bankId;
	
	@Transient
	private String bankName;
	
	@Column(name="branch_id", nullable= false)
	private int branchId;
	
	@Transient
	private String branchName;
	
	
	public int getEmployeeAccountNo() {
		return employeeAccountNo;
	}
	public void setEmployeeAccountNo(int employeeAccountNo) {
		this.employeeAccountNo = employeeAccountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public int getBalence() {
		return balence;
	}
	public void setBalence(int balence) {
		this.balence = balence;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public int getSalaryFlag() {
		return salaryFlag;
	}
	public void setSalaryFlag(int salaryFlag) {
		this.salaryFlag = salaryFlag;
	}
	
	
	
}
