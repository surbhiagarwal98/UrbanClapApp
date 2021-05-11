package com.nagarro.Admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.Admin.enums.OrderRequestState;
import com.nagarro.Admin.model.Order;
import com.nagarro.Admin.model.OrderRequest;
import com.nagarro.Admin.model.ServiceProvider;
import com.nagarro.Admin.util.RandomStringGenerator;

/**
 * This service process order coming from Order Application
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class ProcessOrderService {

	List<OrderRequest> orderRequests = new ArrayList<OrderRequest>();

	/**
	 * generate order request for the order
	 * 
	 * @param order
	 * @return
	 */
	public OrderRequest generateOrderRequest(Order order) {
		OrderRequest orderReq = new OrderRequest(RandomStringGenerator.generateRandomString(), order,
				OrderRequestState.PENDING, "");
		return orderReq;
	}

	/**
	 * add to list of order requests
	 * 
	 * @param orderRequest
	 */
	public void addToOrderRequests(OrderRequest orderRequest) {
		orderRequests.add(orderRequest);
	}

	/**
	 * gets all order requests in the list
	 * 
	 * @return
	 */
	public List<OrderRequest> getAllOrderRequests() {
		return orderRequests;
	}

	/**
	 * gets available service providers as per the area requested by user
	 * 
	 * @param list
	 * @param req
	 * @return
	 */
	public List<ServiceProvider> getAvailableServiceProviderAsPerServiceArea(List<ServiceProvider> list,
			OrderRequest req) {
		List<ServiceProvider> filteredList = new ArrayList<ServiceProvider>();
		for (ServiceProvider s : list) {
			if (s.getIsAvailable().equals("Yes") && s.getCity().equals(req.getorder().getRequestedArea())) {
				filteredList.add(s);
			}

		}
		return filteredList;
	}

}
