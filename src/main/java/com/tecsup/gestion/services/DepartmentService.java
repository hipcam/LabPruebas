package com.tecsup.gestion.services;

import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;
import com.tecsup.gestion.model.Employee;

public interface DepartmentService {

	Department find(int departmentid) throws DAOException, EmptyResultException;

	List<Department> findAll() 
			throws DAOException, EmptyResultException;
}
