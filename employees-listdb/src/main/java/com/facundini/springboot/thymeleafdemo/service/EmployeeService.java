package com.facundini.springboot.thymeleafdemo.service;

import java.util.List;

import com.facundini.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee emp);
	
	public void deleteEmployee(Employee emp);
	
	public Employee findEmployee(int theId);
	
	public List<Employee> getEmployees();

}
