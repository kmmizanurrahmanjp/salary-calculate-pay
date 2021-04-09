package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.Grade;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface GradeService {
	
	public List<Grade> selectAll();
	public Grade selectById(int id);
}

