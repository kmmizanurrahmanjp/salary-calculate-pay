package com.ibcsprimax.assignment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibcsprimax.assignment.entity.Salary;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
@Transactional(readOnly= true)
public class SalaryRepositoryImpl implements SalaryRepositoryCustom{

	
	@PersistenceContext
    EntityManager entityManager;
	
	
	@Override
	public Salary selectSalaryByGradeId(int gradeId) {
		Query query = entityManager.createNativeQuery("SELECT s.* FROM salary as s " +
                "WHERE s.grade_id = ?", Salary.class);
		query.setParameter(1, gradeId);
		return (Salary) query.getSingleResult();
	}

}
