package com.ibcsprimax.assignment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibcsprimax.assignment.entity.Branch;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
@Transactional(readOnly= true)
public class BranchRepositoryImpl implements BranchRepositoryCustom{

	@PersistenceContext
    EntityManager entityManager;

	@Override
	public List<Branch> selectByBankId(int bankId) {
		Query query = entityManager.createNativeQuery("SELECT b.* FROM branch as b " +
                "WHERE b.bank_id = ?", Branch.class);
		query.setParameter(1, bankId);
		return query.getResultList();
	}


	
}
