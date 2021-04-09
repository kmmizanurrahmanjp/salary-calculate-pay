package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.CompanyBankAccount;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface BankAccountService {

	public void insertBalence(int balence);
	public void updateBalence(int balence);
	public void updateBalenceAfterTransfar(int accountNo, int paidAmount);
	public void deleteBalence(int accountNo);
	
	public List<CompanyBankAccount> select();
	public CompanyBankAccount selectByAccountNo(int accountNo);
}
