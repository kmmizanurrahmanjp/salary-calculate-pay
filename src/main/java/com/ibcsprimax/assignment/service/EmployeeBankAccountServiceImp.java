package com.ibcsprimax.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.EmployeeBankAccount;
import com.ibcsprimax.assignment.repository.EmployeeBankAccountRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class EmployeeBankAccountServiceImp implements EmployeeBankAccountService{

	@Autowired
	EmployeeBankAccountRepository repo;
	

	@Override
	public void insertBalenceByAccountNo(int balence, int accountNo) {
		EmployeeBankAccount eba = selectByAccountNo(accountNo);
		int previousBalence = eba.getBalence();
		eba.setBalence(previousBalence + balence);
		eba.setSalaryFlag(1);
		repo.save(eba);
		
	}



	@Override
	public EmployeeBankAccount selectByAccountNo(int accountNo) {
		Optional<EmployeeBankAccount> eba = repo.findById(accountNo);
		return eba.isPresent() ? eba.get() : null;
	}

}
