package com.ibcsprimax.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.BankAccountType;
import com.ibcsprimax.assignment.repository.BanckAccountTypeRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class BankAccountTypeServiceImp implements BankAccountTypeService{
	
	@Autowired
	BanckAccountTypeRepository repo;

	@Override
	public List<BankAccountType> selectAll() {
		return repo.findAll();
	}

	@Override
	public BankAccountType selectById(int id) {
		Optional<BankAccountType> bat = repo.findById(id);
		return bat.isPresent() ? bat.get() : null;
	}
	
}
