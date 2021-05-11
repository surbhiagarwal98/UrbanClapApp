package com.nagarro.Login.model;

import javax.persistence.Entity;

@Entity
public class Order {

	private String OrderId;
	private int requestedServiceId;
	private String requestedArea;
	private User requestedBy;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, int requestedServiceId, String requestedArea, User requestedBy) {
		super();
		OrderId = orderId;
		this.requestedServiceId = requestedServiceId;
		this.requestedArea = requestedArea;
		this.requestedBy = requestedBy;
	}

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getOrderId() {
		return OrderId;
	}

	public void setOrderId(String orderId) {
		OrderId = orderId;
	}

	public int getRequestedServiceId() {
		return requestedServiceId;
	}

	public void setRequestedServiceId(int requestedServiceId) {
		this.requestedServiceId = requestedServiceId;
	}

	public String getRequestedArea() {
		return requestedArea;
	}

	public void setRequestedArea(String requestedArea) {
		this.requestedArea = requestedArea;
	}

}
