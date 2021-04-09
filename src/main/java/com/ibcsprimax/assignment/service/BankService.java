package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.Bank;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface BankService {

	public List<Bank> selectAll();
	public Bank selectById(int id);
}
