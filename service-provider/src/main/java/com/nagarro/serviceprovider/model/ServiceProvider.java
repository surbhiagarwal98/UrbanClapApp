package com.nagarro.serviceprovider.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * service provider entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class ServiceProvider {

	private String serviceProviderId;
	private String name;
	private String city;
	private int serviceId;
	private String contactNo;
	private String emailId;
	private String isAvailable;
	private List<Notification> notifications;

	public ServiceProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceProvider(String serviceProviderId, String name, String city, int serviceId, String contactNo,
			String emailId, String isAvailable, List<Notification> notifications) {
		super();
		this.serviceProviderId = serviceProviderId;
		this.name = name;
		this.city = city;
		this.serviceId = serviceId;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.isAvailable = isAvailable;
		this.notifications = notifications;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
