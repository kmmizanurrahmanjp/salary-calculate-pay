package com.ibcsprimax.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibcsprimax.assignment.service.BankAccountTypeService;
import com.ibcsprimax.assignment.service.BankService;
import com.ibcsprimax.assignment.service.BranchService;
import com.ibcsprimax.assignment.service.GradeService;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/init")
public class InitializationController {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(InitializationController.class);
	/**
	 * This controller is use for load initial data
	 * such as
	 * bank, branch, grade initial table for UI dropdowns
	 */
	
	@Autowired
	BankService bankService;
	
	@Autowired
	BranchService branchService;
	
	@Autowired
	BankAccountTypeService accountTypeService;
	
	@Autowired
	GradeService gradeService;
	
	
	@GetMapping(path = "/grade")
	public ResponseEntity<?> selectGrade(){
		return new ResponseEntity<>(gradeService.selectAll(), HttpStatus.OK);
    }
	
	@GetMapping(path = "/grade/{id}")
	public ResponseEntity<?> selectGradeById(@PathVariable int id){
		return new ResponseEntity<>(gradeService.selectById(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/bank")
	public ResponseEntity<?> selectBank(){
		return new ResponseEntity<>(bankService.selectAll(), HttpStatus.OK);
    }
	
	
	
	@GetMapping(path = "/bank/{id}")
	public ResponseEntity<?> selectBankById(@PathVariable int id){
		return new ResponseEntity<>(bankService.selectById(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/bank/account/type")
	public ResponseEntity<?> selectBankAccountType(){
		return new ResponseEntity<>(accountTypeService.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/bank/account/type/{id}")
	public ResponseEntity<?> selectBankAccountTypeById(@PathVariable int id){
		return new ResponseEntity<>(accountTypeService.selectById(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/branch")
	public ResponseEntity<?> selectBranch(){
		return new ResponseEntity<>(branchService.selectAll(), HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/branch/{id}")
	public ResponseEntity<?> selectBranchById(@PathVariable int id){
		return new ResponseEntity<>(branchService.selectById(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/branch/bank/{id}")
	public ResponseEntity<?> selectBranchByBankId(@PathVariable int id){
		return new ResponseEntity<>(branchService.selectByBankId(id), HttpStatus.OK);
	}
	
	
	
}
