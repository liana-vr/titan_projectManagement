package com.liana.tpma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.liana.tpma.dto.ProjectStatus;
import com.liana.tpma.dto.TimeChartData;
import com.liana.tpma.entities.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT stage as label, COUNT(*) as value "
			+ "FROM project "
			+ "GROUP BY stage")
	public List<ProjectStatus> getProjectStatus();
	
	@Query(nativeQuery=true, value="SELECT name as projectName, start_date as startDate, end_date as endDate"
			+ " FROM project WHERE start_date is not null")
	public List<TimeChartData> getTimeData();
	
	public Project findByProjectId(long theId);

}
