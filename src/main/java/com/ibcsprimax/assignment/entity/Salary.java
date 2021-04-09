package com.ibcsprimax.assignment.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author    Md Mizanur Rahman<kmmizanurrahmanjp@gmail.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Entity
public class Salary implements Serializable{

	private static final long serialVersionUID = -7461579288578833097L;
	
	@Id
	@SequenceGenerator(name = "salarySeqGen", sequenceName = "salarySeq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(generator = "salarySeqGen")
	private int id;
	private int gradeId;
	private int basicSalary;
	private int houseRent;
	private int medicalAllowance;
	private int grossSalary;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getHouseRent() {
		return houseRent;
	}
	public void setHouseRent(int houseRent) {
		this.houseRent = houseRent;
	}
	public int getMedicalAllowance() {
		return medicalAllowance;
	}
	public void setMedicalAllowance(int medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}
	public int getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	
	
}
