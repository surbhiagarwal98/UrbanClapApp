package com.nagarro.Admin.model;

import javax.persistence.Entity;

import com.nagarro.Admin.enums.NotificationResponse;

/**
 * Notification entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class Notification {

	private OrderRequest orderReq;
	private NotificationResponse response;

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(OrderRequest orderReq, NotificationResponse response) {
		super();
		this.orderReq = orderReq;
		this.response = response;
	}

	public OrderRequest getOrderReq() {
		return orderReq;
	}

	public void setOrderReq(OrderRequest orderReq) {
		this.orderReq = orderReq;
	}

	public NotificationResponse getResponse() {
		return response;
	}

	public void setResponse(NotificationResponse response) {
		this.response = response;
	}

}
