# employee-management-system

# create employee-management related database 

 create database employeemanagementdb

# API Details

1. API for Adding a New Employee : http://localhost:8080/api/employeemgmtservice/addNewEmployee
	  
	  eg:
	  {
	   "empName" : "Sijo",
	   "empAddr" : "XYZ",
	   "dob" : "1984-07-02",
	   "deptId" : 102,
	   "deptName" : "HR",
	   "doj" : "2015-02-03",
	   "salary" : 350000.00  
	  }

2. API for getting all the Employees of a particular department : http://localhost:8080/api/employeemgmtservice/retrieveAllEmployees/{deptId}

	eg.http://localhost:8080/api/employeemgmtservice/retrieveAllEmployees/102
	  
3. API for updating the salary of one particular employee :  http://localhost:8080/api/employeemgmtservice/updateEmployeeSalary/{empId}/{salary}

    eg.http://localhost:8080/api/employeemgmtservice/updateEmployeeSalary/1/45000.00
	 