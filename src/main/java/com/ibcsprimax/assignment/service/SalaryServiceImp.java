package com.ibcsprimax.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibcsprimax.assignment.entity.CompanyBankAccount;
import com.ibcsprimax.assignment.entity.Employee;
import com.ibcsprimax.assignment.entity.Salary;
import com.ibcsprimax.assignment.repository.GradeRepository;
import com.ibcsprimax.assignment.repository.SalaryRepository;

/**
 * @author Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class SalaryServiceImp implements SalaryService {

	public static final int INCREMENT_AMOUNT = 5000;
	public static final int HOUSE_RENT_PERCENT = 20;
	public static final int MEDICAL_ALLOWANCE_PERCENT = 15;
	
	
	@Autowired
	SalaryRepository salaryRepo;
	@Autowired
	GradeRepository gradeRepo;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	BankAccountService companyBankAccountService;

	@Autowired
	EmployeeBankAccountService employeeBankAccountService;

	@Override
	public void insertBasic(int lowestGradeBasic) {
		int gradeCount = (int) gradeRepo.count();
		generateBasicSalaryWithGrade(lowestGradeBasic, gradeCount);

	}

	@Override
	public List<Salary> selectAll() {
		return salaryRepo.findAll();
	}

	@Override
	public void update(int lowestGradeBasic) {
		salaryRepo.deleteAll();
		insertBasic(lowestGradeBasic);
	}

	@Override
	public void delete() {
		salaryRepo.deleteAll();

	}

	@Override
	public Salary selectSalaryByGradeId(int gradeId) {
		return salaryRepo.selectSalaryByGradeId(gradeId);
	}

	@Override
	@Transactional
	public Boolean transferSalaryByEmployeeId(int empId) {
		Employee e = employeeService.selectEmployeeById(empId);
		Salary s = selectSalaryByGradeId(e.getGradeId());
		CompanyBankAccount cba = companyBankAccountService.select().get(0);
		if (cba.getBalence() >= s.getGrossSalary()) {
			// update employee account balance by account no
			employeeBankAccountService.insertBalenceByAccountNo(s.getGrossSalary(),
					e.getBankAccount().getEmployeeAccountNo());
			// update company balance and total paid by account no
			companyBankAccountService.updateBalenceAfterTransfar(cba.getCompanyAccountNo(), s.getGrossSalary());
			return true;
		}
		return false;
	}

	//Business logic for salary calculate
	public void generateBasicSalaryWithGrade(int lowestGradeBasic, int gradeCount) {

		int basic = lowestGradeBasic;

		for (int i = gradeCount; i > 0; i--) {
			Salary s = new Salary();
			s.setId(i);
			s.setGradeId(i);
			s.setBasicSalary(basic);
			int houseRent = (basic * HOUSE_RENT_PERCENT) / 100;
			int medicalAllowance = (basic * MEDICAL_ALLOWANCE_PERCENT) / 100;
			s.setHouseRent(houseRent);
			s.setMedicalAllowance(medicalAllowance);
			s.setGrossSalary(basic + houseRent + medicalAllowance);

			basic += INCREMENT_AMOUNT;

			salaryRepo.save(s);
		}
	}

}
