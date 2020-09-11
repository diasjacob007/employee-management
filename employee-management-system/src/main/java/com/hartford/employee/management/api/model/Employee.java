/**
 * 
 */
package com.hartford.employee.management.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employeedetails")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_address")
	private String empAddr;
	@Column(name = "emp_dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(name = "emp_doj")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate doj;
	@Column(name = "dept_id")
	private int deptId;
	@Column(name = "dept_name")
	private String deptName;
	@Column(name = "emp_salary")
	private double salary;

	public Employee() {
	}

	public Employee(int empId, String empName, String empAddr, LocalDate dob, LocalDate doj, int deptId, String deptName,
			double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddr = empAddr;
		this.dob = dob;
		this.doj = doj;
		this.deptId = deptId;
		this.deptName = deptName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddr=" + empAddr + ", dob=" + dob + ", doj="
				+ doj + ", deptId=" + deptId + ", deptName=" + deptName + ", salary=" + salary + "]";
	}
}
