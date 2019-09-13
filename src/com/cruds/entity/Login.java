package com.cruds.entity;

public class Login {
	
	private int lid;
	private String userName;
	private String password;
	
	public Login(int lid) {
		super();
		this.lid = lid;
	}
	
	
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public Login(int lid, String userName, String password) {
		super();
		this.lid = lid;
		this.userName = userName;
		this.password = password;
	}


	public int getLid() {
		return lid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
