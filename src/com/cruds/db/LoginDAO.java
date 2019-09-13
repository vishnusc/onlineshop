package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.entity.Login;
import com.mysql.jdbc.Statement;



public class LoginDAO {
	
	public boolean create(Login login)
	{
		int rows = 0;
		// try with resources
		try(Connection conn = DBConnectionManager.getConnection();)
		{
			String sql = "insert into login(name,password) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			
			ps.executeUpdate();
			System.out.println("Student created successfully");
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return rows > 0;
	}
	
	public Login validateLogin(Login login)
	{
		int rows = 0;
		Login l =null;
		String sql = "select lid,name,password from login where name=? and password=?";
		
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				l = new Login(rs.getInt(1),rs.getString(2), rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
