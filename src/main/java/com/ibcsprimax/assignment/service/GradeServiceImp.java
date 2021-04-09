package com.ibcsprimax.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.Grade;
import com.ibcsprimax.assignment.repository.GradeRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class GradeServiceImp implements GradeService{
	
	@Autowired
	GradeRepository repo;

	@Override
	public List<Grade> selectAll() {
		return repo.findAll();
	}

	@Override
	public Grade selectById(int id) {
		Optional<Grade> list = repo.findById(id);
		return list.isPresent() ? list.get() : null;
	}
	
	
}
