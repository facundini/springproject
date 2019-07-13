package com.facundini.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facundini.springboot.thymeleafdemo.entity.Employee;
import com.facundini.springboot.thymeleafdemo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public void saveEmployee(Employee emp) {
		repository.save(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		repository.delete(emp);
	}

	@Override
	public Employee findEmployee(int theId) {
		return repository.findById(theId).orElse(null);
	}

	@Override
	public List<Employee> getEmployees() {
		return repository.findAllByOrderByLastNameAsc();
	}
	
	

}
