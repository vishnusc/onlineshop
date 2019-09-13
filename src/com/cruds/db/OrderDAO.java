package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.entity.Login;
import com.cruds.entity.Order;
import com.cruds.entity.Product;
import com.mysql.jdbc.Statement;

public class OrderDAO {
	
	
	public List<Order> getOrder(int id)
	{
		Order order =null;
		List<Order> list = new ArrayList<>();
		int oid = 0;
		// try with resources
		try(Connection conn = DBConnectionManager.getConnection();)
		{
			String sql = "select oid,total from order1 where lid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				order = new Order(rs.getInt(1), rs.getFloat(2));
				list.add(order);
				
			}
			//System.out.println("Student created successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return list;
	}

	
	public List<Product> getProduct(int id)
	{
		Product p = null;
		int oid = 0;
		List<Product> pList = new ArrayList<>();
		// try with resources
		try(Connection conn = DBConnectionManager.getConnection();)
		{
			String sql = "select pid,pname,price,oid from product where oid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs != null && rs.next())
			{
				p = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getInt(4));
				pList.add(p);
				
			}
			//System.out.println("Student created successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return pList;
	}
	
	public int addOrder(float total,int lid)
	{
		
		int oid = 0;
		// try with resources
		try(Connection conn = DBConnectionManager.getConnection();)
		{
			String sql = "insert into order1(total,lid) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setFloat(1,total);
			ps.setInt(2, lid);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
            
            if(rs != null && rs.next())
            {
                oid = rs.getInt(1);
            }
			//System.out.println("Student created successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return oid;
	}
	
	public boolean addProduct(int oid,Product product)
	{
		
		int rows = 0;
		// try with resources
		try(Connection conn = DBConnectionManager.getConnection();)
		{
			String sql = "insert into product values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1,product.getPid());
			ps.setString(2, product.getPname());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, oid);
			
			rows = ps.executeUpdate();
			
			
			//System.out.println("Student created successfully");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return rows > 0;
	}
	
	
}
