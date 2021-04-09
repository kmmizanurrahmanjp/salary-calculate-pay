package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.Branch;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface BranchService {

	public List<Branch> selectAll();
	public Branch selectById(int id);
	public List<Branch> selectByBankId(int bankId);
}
