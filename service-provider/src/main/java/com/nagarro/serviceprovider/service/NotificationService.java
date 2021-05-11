package com.nagarro.serviceprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.serviceprovider.model.Notification;

/**
 * notifications service to check notifications
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class NotificationService {
	List<Notification> notifications = new ArrayList<Notification>();

	/**
	 * add new notification to list of notifications
	 * 
	 * @param n
	 * @return
	 */
	public String addNotification(Notification n) {
		notifications.add(n);
		return "Added Notification";
	}

	/**
	 * gets all the notifications
	 * 
	 * @return
	 */
	public List<Notification> getAllNotifications() {
		return notifications;
	}
}
