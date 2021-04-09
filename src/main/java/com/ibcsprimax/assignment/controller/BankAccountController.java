package com.ibcsprimax.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibcsprimax.assignment.entity.CompanyBankAccount;
import com.ibcsprimax.assignment.service.BankAccountService;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/bank/account")
public class BankAccountController {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(BankAccountController.class);
	/**
	 * This controller is Company bank account information related
	 * use for add balance, update and view
	 * 
	 */
	
	@Autowired
	BankAccountService bnService;
	
	
	@GetMapping(path = "/show/balence")
	public ResponseEntity<?> showBalence(){
			return new ResponseEntity<>(bnService.select(), HttpStatus.OK);
    }
	
	
	@GetMapping(path = "/show/balence/{accountNo}")
	public ResponseEntity<?> showBalenceById(@PathVariable int accountNo){
		return new ResponseEntity<>(bnService.selectByAccountNo(accountNo), HttpStatus.OK);
	}
	
	@PostMapping(path = "/add/balence")
	public ResponseEntity<?> addBalence(@RequestParam(value = "balence", required = true) int balence){
		List<CompanyBankAccount> list = bnService.select();
		if(CollectionUtils.isEmpty(list)) {
			bnService.insertBalence(balence);
			return new ResponseEntity<>(bnService.select(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Balence Allrady Added", HttpStatus.OK);
    }
	
	
	@PostMapping(path = "/increment/balence")
	public ResponseEntity<?> incrementBalence(@RequestParam(value = "balence", required = true ) int balence){
		List<CompanyBankAccount> list = bnService.select();
		if(!CollectionUtils.isEmpty(list)) {
			bnService.updateBalence(balence);
			return new ResponseEntity<>(bnService.select(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Please add Balence fast", HttpStatus.OK);
    }
	
	
	@DeleteMapping(path = "/delete/balence")
	public ResponseEntity<?> deleteBalence(@RequestParam(value = "accountNo", required = true) int accountNo){
		List<CompanyBankAccount> list = bnService.select();
		if(!CollectionUtils.isEmpty(list)) {
			bnService.deleteBalence(accountNo);
			return new ResponseEntity<>(bnService.select(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>("There is no Balence", HttpStatus.OK);
    }
	
	
	
	
}
