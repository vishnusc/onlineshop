package com.cruds.entity;

public class Product {

	private int pid;
	private int poid;
	private String pname;
	private float price;
	public Product(int pid, String pname, float price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	
	

	public Product(int pid,String pname, float price,int poid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.poid = poid;
	}



	public int getPoid() {
		return poid;
	}



	public void setPoid(int poid) {
		this.poid = poid;
	}



	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", poid=" + poid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
}
