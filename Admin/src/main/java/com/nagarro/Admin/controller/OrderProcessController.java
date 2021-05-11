package com.nagarro.Admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Admin.service.ProcessOrderService;
import com.nagarro.Admin.constants.Constants;
import com.nagarro.Admin.enums.NotificationResponse;
import com.nagarro.Admin.model.Notification;
import com.nagarro.Admin.model.Order;
import com.nagarro.Admin.model.OrderRequest;
import com.nagarro.Admin.model.ServiceProvider;
import com.nagarro.Admin.model.User;

/**
 * Admin controller to process order at admin side
 * 
 * @author surbhiagarwal
 *
 */
@RestController
@RequestMapping("/process-order")
public class OrderProcessController {

	@Autowired
	private ProcessOrderService processOrderService;

	@Autowired
	private RestTemplate restTemplate;

	private OrderRequest orderReq;

	/**
	 * adds req to order requests list, gets list of sp service specific
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/order-request", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	private String checkOrderRequest(@RequestBody Order order) {
		orderReq = processOrderService.generateOrderRequest(order);
		processOrderService.addToOrderRequests(orderReq);
		String response = "Order recieved : " + order.getOrderId();
		return response;
	}

	/**
	 * gets all order requests
	 * 
	 * @return
	 */
	@RequestMapping("/get-all-requests")
	private List<OrderRequest> getAllRequests() {
		return processOrderService.getAllOrderRequests();
	}

	/**
	 * process order request by sending notifications to all available service
	 * provider
	 * 
	 * @param orderReq
	 * @return
	 */
	@RequestMapping(value = "/serviceProviders", method = RequestMethod.POST)
	private String processOrderRequest(@RequestBody OrderRequest orderReq) {
		String text = "Order Processing!";
		RequestEntity<OrderRequest> request = RequestEntity
				.post(Constants.serviceProviderBaseUrl + Constants.requestServiceProviderUrl)
				.accept(MediaType.APPLICATION_JSON).body(orderReq);
		ParameterizedTypeReference<List<ServiceProvider>> myBean = new ParameterizedTypeReference<List<ServiceProvider>>() {
		};
		ResponseEntity<List<ServiceProvider>> response = restTemplate.exchange(request, myBean);

		List<ServiceProvider> serviceProvidersList = response.getBody();
		List<ServiceProvider> availableServiceProviders = processOrderService
				.getAvailableServiceProviderAsPerServiceArea(serviceProvidersList, orderReq);
		System.out.println("ServiceProvider : " + availableServiceProviders.get(0).getName());

		for (ServiceProvider s : availableServiceProviders) {
			List<Notification> updatedNotifications = new ArrayList<Notification>();
			if (s.getNotifications() != null) {
				for (Notification n : s.getNotifications()) {
					updatedNotifications.add(n);
				}
			}
			try {
				updatedNotifications.add(new Notification(orderReq, NotificationResponse.PENDING));
				s.setNotifications(updatedNotifications);
				text = "Order in process - Notifications sent to service providers!";
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		return text;
	}

	/**
	 * notifies requested user with service provider name and contact number
	 * 
	 * @param notification
	 * @return
	 */
	@RequestMapping(value = "/acceptedresponse", method = RequestMethod.POST)
	private Notification notifyRequestedUser(@RequestBody Notification notification) {
		System.out.println(notification.getResponse() + " " + notification.getOrderReq().getServiceProviderId());
		User requestedBy = notification.getOrderReq().getorder().getRequestedBy();
		System.out.println("Notification sent to user with Service Provider Details");
		return notification;
	}

}
