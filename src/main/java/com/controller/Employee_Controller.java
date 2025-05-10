package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Employee_DTO;
import com.service.Employee_Service;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value="emp/details")
public class Employee_Controller {

	@Autowired
	private Employee_Service serv;
	@GetMapping(path="/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping(path="/get_emp")
	public List<Employee_DTO> get_emp(int emp_id) throws SQLException{
		return serv.get_emp(emp_id);
	}
	
	@PostMapping(path="/insert_emp")
	public String insert_emp(@RequestBody Employee_DTO emp_dto) throws SQLException {
		return serv.insert_emp(emp_dto);
	}
	
	@PutMapping(path="/update_emp")
	public String update_emp(@RequestBody Employee_DTO emp_dto) throws SQLException {
		return serv.update_emp(emp_dto);
	}
	@DeleteMapping(path="/delete_emp")
	public String delete_emp(@RequestParam String id) throws SQLException {
		return serv.delete_emp(id);
	}
}
