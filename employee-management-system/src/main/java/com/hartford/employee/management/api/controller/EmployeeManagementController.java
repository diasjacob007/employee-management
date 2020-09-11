package com.hartford.employee.management.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hartford.employee.management.api.exception.EmployeeNotFoundException;
import com.hartford.employee.management.api.model.Employee;
import com.hartford.employee.management.api.service.EmployeeMgmntServiceImpl;

@RestController
@RequestMapping("/api/employeemgmtservice")
public class EmployeeManagementController {

	@Autowired
	private EmployeeMgmntServiceImpl employeeService;

	@PostMapping("/addNewEmployee")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {
		ResponseEntity<?> responseEntity;
		try {
			employeeService.addNewEmployee(employee);
			responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("{\"message\":\"" + e.getMessage() + "\")",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@GetMapping("/retrieveAllEmployees/{deptId}")
	public ResponseEntity<?> retrieveAllEmployeesOfParticularDept(@PathVariable(name = "deptId") Integer deptId) {
		ResponseEntity<?> responseEntity;
		List<Employee> allEmployeesByDepartmentId = employeeService.getAllEmployeesByDepartmentId(deptId);
		if (allEmployeesByDepartmentId.isEmpty()) {
			String message = "No Employees exists in this department";
			return new ResponseEntity<String>("{\"message\":\"" + message + "\")", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployeesByDepartmentId(deptId), HttpStatus.OK);
	}

	@PutMapping("/updateEmployeeSalary/{empId}/{salary}")
	public ResponseEntity<?> updateNewsContent(@PathVariable(name = "empId") Integer empId,
			@PathVariable(name = "salary") Double salary) {
		ResponseEntity<?> responseEntity = null;
		try {
			Employee retrievedNewsContent = employeeService.updateEmployeeSalary(empId, salary);
			responseEntity = new ResponseEntity<Employee>(retrievedNewsContent, HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<String>("{\"message\":\"" + e.getMessage() + "\")",
					HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
