package com.liana.tpma.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.liana.tpma.dao.EmployeeRepository;
import com.liana.tpma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Employee emp = empRepo.findByEmail(value);
		if (emp != null)
			return false;
		else
			return true;
		
	}
	
}
