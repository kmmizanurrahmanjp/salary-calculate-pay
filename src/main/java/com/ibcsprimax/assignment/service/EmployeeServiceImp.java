package com.ibcsprimax.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcsprimax.assignment.entity.Employee;
import com.ibcsprimax.assignment.entity.EmployeeBankAccount;
import com.ibcsprimax.assignment.repository.BanckAccountTypeRepository;
import com.ibcsprimax.assignment.repository.BankRepository;
import com.ibcsprimax.assignment.repository.BranchRepository;
import com.ibcsprimax.assignment.repository.EmployeeRepository;
import com.ibcsprimax.assignment.repository.GradeRepository;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Autowired
	BanckAccountTypeRepository banckAccountTypeRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Override
	public Employee insertEmployee(Employee e){
		return employeeRepository.save(e);
	}
	
	@Override
	public Employee updateEmployee(int id,Employee e){
		Optional<Employee> empChack = employeeRepository.findById(id);
		if(!empChack.isPresent()) {
			return null;
		}
		e.setEmployeeId(id);
		return employeeRepository.save(e);
	}
	
	@Override
	public boolean deleteEmployee(int id){
		Optional<Employee> empChack = employeeRepository.findById(id);
		if(!empChack.isPresent()) {
			return false;
		}else {
			employeeRepository.deleteById(id);
			return true;
		}
	}
	
	@Override
	public List<Employee> selectEmployee(){
		List<Employee> response = new ArrayList<>();
		 List<Employee> employees= employeeRepository.findAll();
		 
		 for(Employee e : employees) {
			 e.setGradeName(gradeRepository.findById(e.getGradeId()).get().getGradeName());
			 EmployeeBankAccount eba = e.getBankAccount();
			 
			 eba.setAccountTypeName(banckAccountTypeRepository.findById(eba.getAccountTypeId()).get().getAccountTypeName());
			 eba.setBankName(bankRepository.findById(eba.getBankId()).get().getBankName());
			 eba.setBranchName(branchRepository.findById(eba.getBranchId()).get().getBranchName());
			 
			 e.setBankAccount(eba);
			 response.add(e);
		 }
		 
		 return response;
	}
	
	@Override
	public Employee selectEmployeeById(int id){
		Optional<Employee> empChack = employeeRepository.findById(id);
		if(empChack.isPresent()) {
			Employee e = empChack.get();
			e.setGradeName(gradeRepository.findById(e.getGradeId()).get().getGradeName());
			
			EmployeeBankAccount eba = e.getBankAccount();
			eba.setAccountTypeName(banckAccountTypeRepository.findById(eba.getAccountTypeId()).get().getAccountTypeName());
			eba.setBankName(bankRepository.findById(eba.getBankId()).get().getBankName());
			eba.setBranchName(branchRepository.findById(eba.getBranchId()).get().getBranchName());
			e.setBankAccount(eba);
			return e;
		}else {
			return null;
		}
		
	}

	
	
}
