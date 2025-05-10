package com.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.Employee_DAO;
import com.dto.Employee_DTO;
import com.service.Employee_Service;

@Component
public class Employee_ServiceImpl implements Employee_Service {

	@Autowired
	private Employee_DAO emp_dao;

	public List<Employee_DTO> get_emp(int emp_id) throws SQLException {
		return emp_dao.get_emp(emp_id);

	}
	public String insert_emp(Employee_DTO emp_dto) throws SQLException {
		return emp_dao.insert_emp(emp_dto);
	}
	public String update_emp(Employee_DTO emp_dto) throws SQLException {
		return emp_dao.update_emp(emp_dto);
	}
	public String delete_emp(String id) throws SQLException {
		return emp_dao.delete_emp(id);
	}
}
