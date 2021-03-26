package com.liana.tpma;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liana.tpma.dao.EmployeeRepository;
import com.liana.tpma.dao.ProjectRepository;


@SpringBootApplication
public class TitanProjectManagementApplication {

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TitanProjectManagementApplication.class, args);
	}

}
