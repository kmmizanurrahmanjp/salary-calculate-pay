package com.ibcsprimax.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.Branch;
import com.ibcsprimax.assignment.repository.BranchRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class BranchServiceImp implements BranchService{
	
	@Autowired
	BranchRepository repo;

	@Override
	public List<Branch> selectAll() {
		return repo.findAll();
	}

	@Override
	public Branch selectById(int id) {
		Optional<Branch> list = repo.findById(id);
		return list.isPresent() ? list.get() : null;
	}

	@Override
	public List<Branch> selectByBankId(int bankId) {
		return repo.selectByBankId(bankId);
	}
	
	
}
