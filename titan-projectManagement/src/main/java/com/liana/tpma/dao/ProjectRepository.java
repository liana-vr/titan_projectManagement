package com.liana.tpma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.liana.tpma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
}
