package com.ibcsprimax.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibcsprimax.assignment.entity.Salary;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer>, SalaryRepositoryCustom{

}
