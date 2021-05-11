package com.nagarro.Order.controller;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Order.constants.Constants;
import com.nagarro.Order.exceptions.ServiceNotAvailableException;

import com.nagarro.Order.model.Order;
import com.nagarro.Order.model.UrbanService;
import com.nagarro.Order.model.User;
import com.nagarro.Order.service.OrderService;

/**
 * Controller to place order
 * 
 * @author surbhiagarwal
 *
 */
@RestController
@RequestMapping("/place-order")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@Autowired
	private RestTemplate restTemplate;

	private User currentuser;

	/**
	 * gets current user from Login applcation
	 * 
	 * @param user
	 */
	@RequestMapping("/get-currentuser")
	public void getCurrentUser(@RequestBody User user) {
		System.out.println("token: " + user.getName());
		currentuser = user;

	}

	/**
	 * //checks for the service in Service catalog ,checks availability of service
	 * in requested area, if yes then generates order for this service id and sends
	 * this to order request to admin side
	 * 
	 * @param serviceId
	 * @param requestedArea
	 * @return
	 * @throws ServiceNotAvailableException
	 * @throws URISyntaxException
	 */

	@RequestMapping("/{serviceId}/{requestedArea}")
	public String placeOrder(@PathVariable("serviceId") int serviceId,
			@PathVariable("requestedArea") String requestedArea)
			throws ServiceNotAvailableException, URISyntaxException {
		String responseString = "";
		Order order = null;
		UrbanService requestedService = restTemplate
				.getForObject(Constants.catalogBaseurl + Constants.showCatalogUrl + serviceId, UrbanService.class);

		if (orderService.checkServiceAvailabilityByArea(requestedService, requestedArea)) {

			boolean isPaid = false; // check via payment component
			order = orderService.generateOrder(serviceId, requestedArea, currentuser, isPaid);
			URI uri = new URI(Constants.adminBaseurl + Constants.adminOrderRequrl);
			try {
				ResponseEntity<String> result = restTemplate.postForEntity(uri, order, String.class);
				responseString = result.toString();
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else {
			responseString = "Service not available in this area";
			throw new ServiceNotAvailableException("This service is not available in your area");
		}

		return responseString;
	}

}
