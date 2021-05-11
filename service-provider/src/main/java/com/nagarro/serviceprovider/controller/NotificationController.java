package com.nagarro.serviceprovider.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.serviceprovider.constant.Constants;
import com.nagarro.serviceprovider.enums.NotificationResponse;
import com.nagarro.serviceprovider.enums.OrderRequestState;
import com.nagarro.serviceprovider.model.Notification;
import com.nagarro.serviceprovider.model.OrderRequest;
import com.nagarro.serviceprovider.service.NotificationService;

/**
 * notification controller to send notification about order updates
 * 
 * @author surbhiagarwal
 *
 */

@RestController
@RequestMapping("/notify")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * adds new notification as per request
	 * 
	 * @param orderReq
	 * @return
	 */
	@RequestMapping(value = "/newRequest", method = RequestMethod.POST)
	private Notification addNewNotification(@RequestBody OrderRequest orderReq) {
		Notification notification = new Notification(orderReq, NotificationResponse.PENDING);
		System.out.println("New notification created");
		notificationService.addNotification(notification);
		return notification;
	}

	/**
	 * gets all notifications
	 * 
	 * @return
	 */
	@RequestMapping(value = "/allNotifications")
	private List<Notification> getAllNotifications() {
		List<Notification> notifications = notificationService.getAllNotifications();
		return notifications;
	}

	/**
	 * accepts response from service providers and sets status of notifications
	 * 
	 * @param notification
	 * @return
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/respond-accept", method = RequestMethod.POST)
	private Notification acceptReq(@RequestBody Notification notification) throws URISyntaxException {

		notification.setResponse(NotificationResponse.ACCEPT);
		notification.getOrderReq().setOrderState(OrderRequestState.ASSIGNED);
		notification.getOrderReq().setServiceProviderId("shdjsd");
		String baseurl = Constants.adminBaseUrl + Constants.adminAcceptedResponseUrl;
		URI uri = new URI(baseurl);

		try {
			ResponseEntity<Notification> response = restTemplate.postForEntity(uri, notification, Notification.class);
			Notification acceptedNotification = response.getBody();
			System.out.println("Order ID : " + acceptedNotification.getOrderReq().getorderId() + " is accepted.");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return notification;
	}

	/**
	 * rejects notfication for order req
	 * 
	 * @param notification
	 * @return
	 */
	@RequestMapping(value = "/respond-reject")
	private Notification rejectReq(@RequestBody Notification notification) {
		notification.setResponse(NotificationResponse.REJECT);
		return notification;
	}

}
