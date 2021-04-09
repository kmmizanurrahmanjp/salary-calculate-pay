package com.ibcsprimax.assignment.service;

import java.util.List;

import com.ibcsprimax.assignment.entity.Salary;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface SalaryService {

	public void insertBasic(int lowestGradeBasic);
	public void update(int lowestGradeBasic);
	public void delete();
	
	public List<Salary> selectAll();
	public Salary selectSalaryByGradeId(int gradeId);
	
	public Boolean transferSalaryByEmployeeId(int empId);
}
