package com.liana.tpma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liana.tpma.dao.EmployeeRepository;
import com.liana.tpma.dao.ProjectRepository;
import com.liana.tpma.dto.EmployeeProject;
import com.liana.tpma.dto.ProjectStatus;
import com.liana.tpma.dto.TimeChartData;
import com.liana.tpma.entities.Project;
import com.liana.tpma.services.ProjectService;

@Controller
public class HomeController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
						
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<ProjectStatus> projectData = proRepo.getProjectStatus();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCount", jsonString);
		
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectCount", employeesProjectCount);
		
		List<TimeChartData> timelineData = proRepo.getTimeData();
		
		ObjectMapper objectTimeMapper = new ObjectMapper();
		String jsonTimelineString = objectTimeMapper.writeValueAsString(timelineData);
		
		model.addAttribute("projectTimeList", jsonTimelineString);
		
		return "main/home";
	}
}
