package com.ibcsprimax.assignment.repository;

import com.ibcsprimax.assignment.entity.Salary;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface SalaryRepositoryCustom {

	public Salary selectSalaryByGradeId(int gradeId);
}
