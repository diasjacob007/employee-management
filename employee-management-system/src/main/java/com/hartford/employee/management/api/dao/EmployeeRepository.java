/**
 * 
 */
package com.hartford.employee.management.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hartford.employee.management.api.model.Employee;

/*
 * This is the repository which is defined for performing all the CRUD
 * related operations
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findEmployeesByDeptId(Integer departmentId);
}
