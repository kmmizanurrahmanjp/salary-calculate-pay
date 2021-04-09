package com.ibcsprimax.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Controller
@RequestMapping("/")
public class UIController {

	/**
	 * This controller is use for redirect UI without data
	 * 
	 */
	
	public String index() {
		return "index";
	}
	
	@RequestMapping("/lowest_salary")
	public String lowest_salary() {
		return "lowest_salary";
	}
	
	
	@RequestMapping("/company_balance")
	public String company_balance() {
		return "company_balance";
	}
	
	@RequestMapping("/salary_calculate")
	public String salary_calculate() {
		return "salary_calculate";
	}
	
	
	@RequestMapping("/salary_transfer")
	public String salary_transfer() {
		return "salary_transfer";
	}
	
	
	@RequestMapping("/salary_sheet")
	public String salary_sheet() {
		return "salary_sheet";
	}
	
	
	@RequestMapping("/balance_sheet")
	public String balance_sheet() {
		return "balance_sheet";
	}
}