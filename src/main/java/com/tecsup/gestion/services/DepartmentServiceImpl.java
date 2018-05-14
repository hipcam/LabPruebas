package com.tecsup.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.gestion.dao.DepartmentDAO;
import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;
import com.tecsup.gestion.model.Employee;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public Department find(int departmentid) throws DAOException, EmptyResultException {
		
		Department dep = departmentDAO.findDepartmentById(departmentid);

		return dep;
	}

	@Override
	public List<Department> findAll() throws DAOException, EmptyResultException {
		List<Department> deps = departmentDAO.findAllDepartments();
		
		return deps;
	}

}

