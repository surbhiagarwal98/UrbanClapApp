package com.nagarro.Order.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * user entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class User {

	private String email;
	private String password;
	private String contactNumber;
	private String name;
	private String address;
	private List<Order> orders;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password, String contactNumber, String name, String address, List<Order> orders) {
		super();
		this.contactNumber = contactNumber;
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getcontactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
