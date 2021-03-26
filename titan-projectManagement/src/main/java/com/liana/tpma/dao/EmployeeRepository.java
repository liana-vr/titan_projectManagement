package com.liana.tpma.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.liana.tpma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();
}