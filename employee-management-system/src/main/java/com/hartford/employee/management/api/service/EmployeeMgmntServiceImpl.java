/**
 * 
 */
package com.hartford.employee.management.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hartford.employee.management.api.dao.EmployeeRepository;
import com.hartford.employee.management.api.exception.EmployeeAlreadyExistsException;
import com.hartford.employee.management.api.exception.EmployeeNotFoundException;
import com.hartford.employee.management.api.model.Employee;

/*
 * This is the service layer implementation
 */
@Service
public class EmployeeMgmntServiceImpl implements EmployeeMgmntServiceIntrf {

	@Autowired
	private EmployeeRepository repository;

	/*
	 * Method for adding a new employee
	 */
	@Override
	public boolean addNewEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		final Optional<Employee> employeeObj = repository.findById(employee.getEmpId());
		if (employeeObj.isPresent()) {
			throw new EmployeeAlreadyExistsException(
					"You are not able to save this employee, as this employee already exists.");
		}
		repository.save(employee);
		return true;
	}

	/*
	 * Method for updating the salary of an existing employee
	 */
	@Override
	public Employee updateEmployeeSalary(Integer empId, Double salary) throws EmployeeNotFoundException {
		Employee employee = repository.findById(empId).orElse(null);
		if (employee == null) {
			throw new EmployeeNotFoundException(
					"This employee id you have provided not exists.So not able to update the salary!!!");
		}
		employee.setSalary(salary);
		repository.save(employee);
		return employee;
	}

	/*
	 * Method for retrieving all the Employees corresponding to one particular
	 * department
	 */
	@Override
	public List<Employee> getAllEmployeesByDepartmentId(Integer deptId) {
		return repository.findEmployeesByDeptId(deptId);
	}
}
