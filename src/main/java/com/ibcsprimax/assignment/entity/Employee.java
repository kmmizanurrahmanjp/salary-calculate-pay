package com.ibcsprimax.assignment.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 3540582086400336387L;
	
	@Id
	@SequenceGenerator(name = "empolyeeSeqGen", sequenceName = "employeeSeq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(generator = "empolyeeSeqGen")
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="name", nullable= false)
	private String name;
	
	@Column(name="address", nullable= false)
	private String address;
	
	@Column(name="mobile", unique=true, nullable= false)
	private String mobile;
	
	@Column(name="grade_id", nullable= false)
	private int gradeId;
	
	@Transient
 	private String gradeName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private EmployeeBankAccount bankAccount;

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public EmployeeBankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(EmployeeBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	
}
