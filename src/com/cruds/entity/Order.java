package com.cruds.entity;

import java.util.Date;

public class Order {

	int orderId;
	float total;
	
	
	public Order(int orderId, float total) {
		super();
		this.orderId = orderId;
		this.total = total;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", total=" + total + "]";
	}
	
	
}
