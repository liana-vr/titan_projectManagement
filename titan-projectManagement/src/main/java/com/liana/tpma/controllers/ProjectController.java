package com.liana.tpma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liana.tpma.entities.Employee;
import com.liana.tpma.entities.Project;
import com.liana.tpma.services.EmployeeService;
import com.liana.tpma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		Iterable<Employee> employees = empService.getAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		
		proService.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects ";
		
	}
	
//	@GetMapping("/timelines")
//	public String displayProjectTimelines(Model model) throws JsonProcessingException {
//		
//		List<TimeChartData> timelineData = proService.getTimeData();
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonTimelineString = objectMapper.writeValueAsString(timelineData);
//
//		System.out.println("---------- project timelines ----------");
//		System.out.println(jsonTimelineString);
//		
//		model.addAttribute("projectTimeList", jsonTimelineString);
//		
//		return "projects/project-timelines";
//	}

}