package com.nagarro.Order.service;

import org.springframework.stereotype.Service;

import com.nagarro.Order.model.Order;
import com.nagarro.Order.model.UrbanService;
import com.nagarro.Order.model.User;
import com.nagarro.Order.util.RandomStringGenerator;

/**
 * service to generate order
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class OrderService {

	/**
	 * checks if order is available in the requested service
	 * 
	 * @param requestedService
	 * @param requestedArea
	 * @return
	 */
	public boolean checkServiceAvailabilityByArea(UrbanService requestedService, String requestedArea) {
		if (requestedService.getAvailabilityAreas().contains(requestedArea)) {
			return true;
		}
		return false;
	}

	/**
	 * generates order for requested service id and area
	 * 
	 * @param serviceId
	 * @param requestedArea
	 * @param requestedBy
	 * @param isPaid
	 * @return
	 */
	public Order generateOrder(int serviceId, String requestedArea, User requestedBy, boolean isPaid) {

		Order order = new Order(RandomStringGenerator.generateRandomString(), serviceId, requestedArea, requestedBy,
				isPaid);
		return order;
	}
}
