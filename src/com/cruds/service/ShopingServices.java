package com.cruds.service;


import java.util.List;

import com.cruds.db.LoginDAO;
import com.cruds.db.OrderDAO;
import com.cruds.entity.Login;
import com.cruds.entity.Order;
import com.cruds.entity.Product;


public class ShopingServices {

	public static boolean create(Login login)
	{
		LoginDAO dao = new LoginDAO();
		return dao.create(login);
	}
	
	public static Login validateLogin(Login login)
	{
		LoginDAO dao = new LoginDAO();
		return dao.validateLogin(login);
	}
	
	public static int addOrder(float total,int lid){
		OrderDAO dao = new OrderDAO();
		return dao.addOrder(total,lid);
	}
	
	public boolean addProduct(int oid,Product product){
		OrderDAO dao = new OrderDAO();
		return dao.addProduct(oid,product);
	}
	
	public List<Product> getProduct(int oid){
		OrderDAO dao = new OrderDAO();
		return dao.getProduct(oid);
	}
	
	public List<Order> getOrder(int lid){
		OrderDAO dao = new OrderDAO();
		return dao.getOrder(lid);
	}
}
