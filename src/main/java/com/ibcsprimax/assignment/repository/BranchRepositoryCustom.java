package com.ibcsprimax.assignment.repository;

import java.util.List;

import com.ibcsprimax.assignment.entity.Branch;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface BranchRepositoryCustom{

	public List<Branch> selectByBankId(int bankId);
}
