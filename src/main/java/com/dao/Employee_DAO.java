package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbconfig.ConnectionManager;
import com.dto.Employee_DTO;

@Repository
public class Employee_DAO {

	
	public List<Employee_DTO> get_emp(int emp_id) throws SQLException{
		Connection connection =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String proc="";
		List<Employee_DTO> al = new ArrayList<Employee_DTO>();
		try {
			if(connection==null) {
				connection = ConnectionManager.getConnectionManager();
			}
			
			proc="{call get_emp('"+emp_id+"')}";
			ps=connection.prepareStatement(proc);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Employee_DTO dto = new Employee_DTO();
				
				dto.setEmp_id(rs.getInt(1));
				dto.setEmp_name(rs.getString(2));
				dto.setEmp_phone(rs.getString(3));
				dto.setEmp_address(rs.getString(4));
				dto.setEmp_designation(rs.getString(5));
				
				al.add(dto);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(connection!=null) {
				connection.close();
			}
			connection=null;
			if(ps!=null) {
				ps.close();
			}
			ps=null;
			if(rs!=null) {
				rs.close();
			}
			rs=null;
		}
		return al;
	}
	
	
	public String insert_emp(Employee_DTO emp_dto) throws SQLException{
		Connection connection =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String proc="";
		String status="";
		try {
			if(connection==null) {
				connection = ConnectionManager.getConnectionManager();
			}
			
			System.out.println(emp_dto.getEmp_name());
			proc="{call insert_emp(?,?,?,?)}"; //'"+ emp_dto.getEmp_name() +"','"+emp_dto.getEmp_phone()+"','"+emp_dto.getEmp_address()+"','"+emp_dto.getEmp_designation()+"'
			ps=connection.prepareStatement(proc);
			ps.setString(1, emp_dto.getEmp_name());
			ps.setString(2, emp_dto.getEmp_phone());
			ps.setString(3, emp_dto.getEmp_address());
			ps.setString(4, emp_dto.getEmp_designation());
			rs=ps.executeQuery();
			System.out.println(ps.toString());
			
			
			if(rs.next()) {
	            status = "SUCCESS";
	        }
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(connection!=null) {
				connection.close();
			}
			connection=null;
			if(ps!=null) {
				ps.close();
			}
			ps=null;
			if(rs!=null) {
				rs.close();
			}
			rs=null;
		}
		return status;
	}
	
	public String update_emp(Employee_DTO emp_dto) throws SQLException {
		Connection connection =null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		String proc="";
		String status="";
		try {
			if(connection==null) {
				connection = ConnectionManager.getConnectionManager();
			}
			proc ="{call update_emp('"+emp_dto.getEmp_id()+"','"+emp_dto.getEmp_phone()+"','"+emp_dto.getEmp_address()+"','"+emp_dto.getEmp_designation()+"')}";
			ps = connection.prepareStatement(proc);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			if(rs.next()) {
				status = rs.getString(1);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(connection!=null) {
				connection.close();
			}
			connection=null;
			if(ps!=null) {
				ps.close();
			}
			ps=null;
			if(rs!=null) {
				rs.close();
			}
			rs=null;
		}
		return status;
	}
	
	public String delete_emp(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		String status="";
		String proc="";
		try {
			if(connection==null) {
				connection=ConnectionManager.getConnectionManager();
			}
			proc="{call delete_emp('"+id+"')}";
			ps=connection.prepareStatement(proc);
			rs=ps.executeQuery();
			if(rs.next()) {
				status=rs.getString(1);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		finally {
			if(connection !=null) {
				connection.close();
			}
			connection=null;
			if(ps!=null) {
				ps.close();
			}
			ps=null;
			if(rs!=null) {
				rs.close();
			}
			rs=null;
		}
		return status;
	}
}
