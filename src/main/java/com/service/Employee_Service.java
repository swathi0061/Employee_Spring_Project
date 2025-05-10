package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Employee_DTO;

@Service
public interface Employee_Service {

	public List<Employee_DTO> get_emp(int emp_id) throws SQLException;
	
	public String insert_emp(Employee_DTO emp_dto) throws SQLException;
	
	public String update_emp(Employee_DTO emp_dto) throws SQLException ;
	
	public String delete_emp(String id) throws SQLException ;
}
