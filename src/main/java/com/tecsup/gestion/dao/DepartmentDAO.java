package com.tecsup.gestion.dao;
import java.util.List;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;
import com.tecsup.gestion.model.Employee;
public interface DepartmentDAO {
	
Department findDepartmentById(int id) throws DAOException, EmptyResultException;
	
	void create( String name, String description, String city) throws DAOException;
	
	void update( String name, String description, String city) throws DAOException;
	
	void delete(String name) throws DAOException;
	
	List<Department> findAllDepartments() throws DAOException, EmptyResultException;
	
	Department findDepartmentByName(String name) throws DAOException, EmptyResultException;
}
