package com.nagarro.serviceprovider.model;

import javax.persistence.Entity;

import com.nagarro.serviceprovider.enums.OrderRequestState;

/**
 * order request entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class OrderRequest {
	private String orderId;
	private Order order;
	private OrderRequestState orderState;
	private String serviceProviderId;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(String orderId, Order order, OrderRequestState orderState, String serviceProviderId) {
		super();
		this.orderId = orderId;
		this.order = order;
		this.orderState = orderState;
		this.serviceProviderId = serviceProviderId;
	}

	public String getorderId() {
		return orderId;
	}

	public void setorderId(String orderId) {
		this.orderId = orderId;
	}

	public Order getorder() {
		return order;
	}

	public void setorder(Order order) {
		this.order = order;
	}

	public OrderRequestState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderRequestState orderState) {
		this.orderState = orderState;
	}

	public String getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

}
