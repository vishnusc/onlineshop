package com.cruds.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Product> list = new ArrayList<>();
	

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	

	public void addToCart(Product p)
	{
		list.add(p);
	}
	
	
	
}
