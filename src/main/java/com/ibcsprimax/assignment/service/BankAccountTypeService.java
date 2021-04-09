package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.BankAccountType;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface BankAccountTypeService {
	
	public List<BankAccountType> selectAll();
	public BankAccountType selectById(int id);
}
