package com.ibcsprimax.assignment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibcsprimax.assignment.entity.Employee;
import com.ibcsprimax.assignment.entity.Salary;
import com.ibcsprimax.assignment.service.BankAccountService;
import com.ibcsprimax.assignment.service.EmployeeBankAccountService;
import com.ibcsprimax.assignment.service.EmployeeService;
import com.ibcsprimax.assignment.service.SalaryService;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SalaryController.class);
	/**
	 * This controller is use for add lowest grade salary, salary calculate and salary transfer
	 * 
	 */
	
	@Autowired
	SalaryService salaryService;
	@Autowired
	EmployeeService empService;
	
	@Autowired
	BankAccountService cbService;
	
	@Autowired
	EmployeeBankAccountService ebaService;
	
	
	@GetMapping(path = "/show/basic/lowest/grade")
	public ResponseEntity<?> showBasicSalary(){
		return new ResponseEntity<>(salaryService.selectAll(), HttpStatus.OK);
    }
	
	@PostMapping(path = "/add/basic/lowest/grade")
	public ResponseEntity<?> addBasicSalary(@RequestParam(value = "lowestGradeBasicSalary", required = true) int lowestGradeBasicSalary){
		List<Salary> list = salaryService.selectAll();
		if(CollectionUtils.isEmpty(list)) {
			salaryService.insertBasic(lowestGradeBasicSalary);
			return new ResponseEntity<>(salaryService.selectAll(), HttpStatus.OK);
		}else {
			salaryService.update(lowestGradeBasicSalary);
			return new ResponseEntity<>(salaryService.selectAll(), HttpStatus.OK);
		}
		
    }
	
	
	@PutMapping(path = "/balence/transfar/by/employee/{employeeId}")
	public ResponseEntity<?> transferBalence(@PathVariable int employeeId){
		if(salaryService.transferSalaryByEmployeeId(employeeId)) {
			return new ResponseEntity<>("Salary Transfer", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("please add balence in company bank account", HttpStatus.OK);
    }
	
	@GetMapping(path = "/sheet/{employeeId}")
	public ResponseEntity<?> displaySalarySheet(@PathVariable int employeeId){
		Employee e = empService.selectEmployeeById(employeeId);
		Salary s = salaryService.selectSalaryByGradeId(e.getGradeId());
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("employeeId", e.getEmployeeId());
		response.put("name", e.getName());
		response.put("gradeName", e.getGradeName());
		response.put("basicSalary", s.getBasicSalary());
		response.put("houseRent", s.getHouseRent());
		response.put("medicalAllowance", s.getMedicalAllowance());
		response.put("grossSalary", s.getGrossSalary());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/calculate")
	public ResponseEntity<?> calculateSalaryt(){
		List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
		
		List<Employee> employees = empService.selectEmployee();
		for(Employee e : employees) {
			Salary s = salaryService.selectSalaryByGradeId(e.getGradeId());
			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("employeeId", e.getEmployeeId());
			data.put("name", e.getName());
			data.put("gradeName", e.getGradeName());
			data.put("basicSalary", s.getBasicSalary());
			data.put("houseRent", s.getHouseRent());
			data.put("medicalAllowance", s.getMedicalAllowance());
			data.put("grossSalary", s.getGrossSalary());
			
			response.add(data);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
}
