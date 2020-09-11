/**
 * 
 */
package com.hartford.employee.management.api.service;

import java.util.List;

import com.hartford.employee.management.api.exception.EmployeeAlreadyExistsException;
import com.hartford.employee.management.api.exception.EmployeeNotFoundException;
import com.hartford.employee.management.api.model.Employee;

public interface EmployeeMgmntServiceIntrf {

	public boolean addNewEmployee(Employee employee) throws EmployeeAlreadyExistsException;

	public List<Employee> getAllEmployeesByDepartmentId(Integer deptId);

	public Employee updateEmployeeSalary(Integer empId, Double salary) throws EmployeeNotFoundException;
}
