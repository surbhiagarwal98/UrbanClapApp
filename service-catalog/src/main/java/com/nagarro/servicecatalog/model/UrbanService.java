package com.nagarro.servicecatalog.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * service entity
 * 
 * @author surbhiagarwal
 *
 */
@Entity
public class UrbanService {

	private int serviceId;
	private String serviceName;
	private String serviceRating;
	private List<String> availabilityAreas;

	public UrbanService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UrbanService(int serviceId, String serviceName, String serviceRating, List<String> availabilityAreas) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceRating = serviceRating;
		this.availabilityAreas = availabilityAreas;
	}

	public List<String> getAvailabilityAreas() {
		return availabilityAreas;
	}

	public void setAvailabilityAreas(List<String> availabilityAreas) {
		this.availabilityAreas = availabilityAreas;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(String serviceRating) {
		this.serviceRating = serviceRating;
	}

}
