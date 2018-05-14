package com.tecsup.gestion.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.tecsup.gestion.model.Department;
public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dep = new Department();
		dep.setDepartmentid(rs.getInt("departmentid"));
		dep.setDescription(rs.getString("description"));
        dep.setName(rs.getString("name"));
        dep.setName(rs.getString("city"));
		return dep;
	}

	
}
