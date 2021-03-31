package com.liana.tpma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liana.tpma.dao.ProjectRepository;
import com.liana.tpma.dto.ProjectStatus;
import com.liana.tpma.dto.TimeChartData;
import com.liana.tpma.entities.Project;


@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository proRepo;
	
	
	public Project save(Project project) {
		return proRepo.save(project);
	}


	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ProjectStatus> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
	
	public List<TimeChartData> getTimeData(){
		return proRepo.getTimeData();
	}
	
	public Project findByProjectId(long theId) {
		// TODO Auto-generated method stub
		return proRepo.findByProjectId(theId);
	}


	public void delete(Project thePro) {
		proRepo.delete(thePro);
		
	}
}

