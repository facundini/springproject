package com.facundini.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facundini.springboot.thymeleafdemo.entity.Admin;
import com.facundini.springboot.thymeleafdemo.entity.Employee;
import com.facundini.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> listEmployees = service.getEmployees();
		
		theModel.addAttribute("employees", listEmployees);
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {

			return "employee-form";
		}
		
		service.saveEmployee(theEmployee);

		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = service.findEmployee(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		service.deleteEmployee(service.findEmployee(theId));
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForLogin")
	public String showFormForLogin(Model theModel) {
		
		theModel.addAttribute("admin", new Admin());
		
		return "login-form";
	}
	
}