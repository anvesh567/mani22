package com.pawana.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawana.bean.Employee;

@Service
public class EmployeeService {

	@Autowired
	private DataSource dataSource;

	public Employee getEmployee(Integer id ) {

		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp where id="+id);
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(String.valueOf(resultSet.getInt("id")));;
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				return employee;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	public Employee insertEmployee(Employee employee) throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement preparestatement=connection.prepareStatement("insert into emp values(?,?,?)");
		preparestatement.setInt(1, Integer.valueOf(employee.getId()));
		preparestatement.setString(2, employee.getName());
		preparestatement.setString(3, employee.getAddress());
		if(preparestatement.executeUpdate()>0)
		{
		return employee;
		}
		return null;
	}
	public Employee updateEmployee(Employee employee) throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement preparestatement=connection.prepareStatement("update emp set name=?,address=? where id=?");
		
		preparestatement.setString(1, employee.getName());
		preparestatement.setString(2, employee.getAddress());
		preparestatement.setInt(3,Integer.valueOf(employee.getId()));
		int i=preparestatement.executeUpdate()	;
		if(i>0)
		return employee;
		return null;	
		
	}
	public String deleteEmployee(Integer id) throws SQLException
	{
		Connection connection=dataSource.getConnection();
		PreparedStatement preparestatement=connection.prepareStatement("delete from emp where id=" +id);
		
		if(preparestatement.executeUpdate()>0)
		{
			return "delete";
		}
		return null;
		
	}


}
