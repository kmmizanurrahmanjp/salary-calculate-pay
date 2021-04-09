package com.ibcsprimax.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.CompanyBankAccount;
import com.ibcsprimax.assignment.repository.BankAccountRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class BankAccountServiceImp implements BankAccountService{

	/**
	 * Company bank account service. During insert balance amount, initial information of account are save for first time
	 * then it will update later.
	 */
	public static final String ACCOUNT_NAME = "IBCS-Primax Software (Bangladesh) Limited";
	public static final String ACCOUNT_TYPE = "Savings";
	public static final String BANK = "Brack Bank Limited";
	public static final String BRANCH = "Mohammadpur Branch";
	
	
	@Autowired
	BankAccountRepository repo;
	
	@Override
	public void insertBalence(int balence) {
		CompanyBankAccount e = new CompanyBankAccount();
		e.setAccountName(ACCOUNT_NAME);
		e.setAccountType(ACCOUNT_TYPE);
		e.setBalence(balence);
		e.setBankName(BANK);
		e.setBranchName(BRANCH);
		e.setTotalPaidAmount(0);
		repo.save(e);
	}

	@Override
	public List<CompanyBankAccount> select() {
		return repo.findAll();
	}

	@Override
	public void updateBalence(int balence) {
		CompanyBankAccount c = repo.findAll().get(0);
		c.setBalence(c.getBalence() + balence);
		repo.save(c);
	}

	@Override
	public void deleteBalence(int accountNo) {
		repo.deleteById(accountNo);
		
	}

	@Override
	public CompanyBankAccount selectByAccountNo(int accountNo) {
		Optional<CompanyBankAccount> c =  repo.findById(accountNo);
		return c.isPresent() ? c.get() : null;
		 
	}

	@Override
	public void updateBalenceAfterTransfar(int accountNo, int paidAmount) {
		CompanyBankAccount cba = selectByAccountNo(accountNo);
		int previousBalence = cba.getBalence();
		int previousPaidBalence = cba.getTotalPaidAmount();
		
		cba.setBalence(previousBalence - paidAmount);
		cba.setTotalPaidAmount(previousPaidBalence + paidAmount);
		repo.save(cba);
		
	}

}
