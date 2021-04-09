package com.ibcsprimax.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.Bank;
import com.ibcsprimax.assignment.repository.BankRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class BankServiceImp implements BankService{
	
	@Autowired
	BankRepository repo;

	@Override
	public List<Bank> selectAll() {
		return repo.findAll();
	}

	@Override
	public Bank selectById(int id) {
		Optional<Bank> list = repo.findById(id);
		return list.isPresent() ? list.get() : null;
	}
	
	
	
}
