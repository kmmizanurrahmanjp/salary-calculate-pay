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
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibcsprimax.assignment.entity.Employee;
import com.ibcsprimax.assignment.entity.Salary;
import com.ibcsprimax.assignment.service.EmployeeService;
import com.ibcsprimax.assignment.service.SalaryService;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	/**
	 * This controller is use for employee CRUD such as basic data, account, branch etc.
	 * 
	 */
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SalaryService salaryService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Object> insertEmployee(@RequestBody Employee e){
		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = employeeService.insertEmployee(e);
		if(employee.equals(null)) {
			response.put("success", false);
			response.put("massage", "Employee save failed");
		}else {
			response.put("success", true);
			response.put("data", employeeService.selectEmployeeById(e.getEmployeeId()));
			response.put("massage", "Employee save Success");
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Map<String, Object> updateEmployee(@PathVariable int id,@RequestBody Employee e){
		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = employeeService.updateEmployee(id,e);
		if(null == employee) {
			response.put("success", false);
			response.put("massage", "Employee update failed");
		}else {
			response.put("success", true);
			response.put("data", employeeService.selectEmployeeById(id));
			response.put("massage", "Employee update Success");
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Map<String, Object> deleteEmployee(@PathVariable int id){
		Map<String, Object> response = new HashMap<String, Object>();
		if(employeeService.deleteEmployee(id) == true) {
			response.put("success", true);
			response.put("massage", "Employee delete success");
		}else {
			response.put("success", false);
			response.put("massage", "Employee delete failed");
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> selectEmployee(){
		Map<String, Object> response = new HashMap<String, Object>();
		List<Employee> employees = employeeService.selectEmployee();
		
		if(employees.isEmpty()) {
			response.put("success", false);
			response.put("data", employees);
			response.put("massage", "Employee selected failed");
		}else {
			response.put("success", true);
			response.put("data", employees);
			response.put("massage", "Employee selected Success");
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Map<String, Object> selectEmployeeById(@PathVariable int id){
		Map<String, Object> response = new HashMap<String, Object>();
		Employee employee = employeeService.selectEmployeeById(id);
		if(null == employee) {
			response.put("success", false);
			response.put("data", employee);
			response.put("massage", "Employee selected failed");
		}else {
			response.put("success", true);
			response.put("data", employee);
			response.put("massage", "Employee selected Success");
		}
		return response;
	}
	
	@GetMapping(path = "/unpaid/salary/list")
	public ResponseEntity<?> selectEmployeeForUnpaidSalary(){
		List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
		
		List<Employee> employees = employeeService.selectEmployee();
		for(Employee e : employees) {
			Map<String, Object> data = new HashMap<String, Object>();
			Salary s = salaryService.selectSalaryByGradeId(e.getGradeId());
			
			if(!ObjectUtils.isEmpty(e)) {
				if(e.getBankAccount().getBalence() == 0 && e.getBankAccount().getSalaryFlag() != 1) {
					data.put("employeeId", e.getEmployeeId());
					data.put("name", e.getName());
					data.put("gradeName", e.getGradeName());
					data.put("grossSalary", s.getGrossSalary());
					data.put("balance", e.getBankAccount().getBalence());
					response.add(data);
				}
			}
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/paid/salary/list")
	public ResponseEntity<?> selectEmployeeForPaidSalary(){
		List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
		
		List<Employee> employees = employeeService.selectEmployee();
		for(Employee e : employees) {
			Map<String, Object> data = new HashMap<String, Object>();
			Salary s = salaryService.selectSalaryByGradeId(e.getGradeId());
			
			if(!ObjectUtils.isEmpty(e)) {
				if(e.getBankAccount().getBalence() != 0 && e.getBankAccount().getSalaryFlag() == 1) {
					data.put("employeeId", e.getEmployeeId());
					data.put("name", e.getName());
					data.put("gradeName", e.getGradeName());
					data.put("grossSalary", s.getGrossSalary());
					data.put("balance", e.getBankAccount().getBalence());
					response.add(data);
				}
			}
			
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
}
