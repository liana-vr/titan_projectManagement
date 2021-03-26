package com.liana.tpma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.liana.tpma.dao.EmployeeRepository;
import com.liana.tpma.dao.ProjectRepository;
import com.liana.tpma.entities.Employee;
import com.liana.tpma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "main/home";
	}
}
