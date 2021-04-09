package com.ibcsprimax.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibcsprimax.assignment.entity.EmployeeBankAccount;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public interface EmployeeBankAccountRepository extends JpaRepository<EmployeeBankAccount, Integer>{

}
