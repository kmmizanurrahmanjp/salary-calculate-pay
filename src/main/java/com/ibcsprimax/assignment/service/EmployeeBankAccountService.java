package com.ibcsprimax.assignment.service;

import com.ibcsprimax.assignment.entity.EmployeeBankAccount;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface EmployeeBankAccountService {

	public void insertBalenceByAccountNo(int balence, int accountNo);
	
	public EmployeeBankAccount selectByAccountNo(int accountNo);
}
