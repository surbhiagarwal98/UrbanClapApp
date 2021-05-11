package com.nagarro.serviceprovider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.serviceprovider.model.OrderRequest;
import com.nagarro.serviceprovider.model.ServiceProvider;
import com.nagarro.serviceprovider.service.DirectOrderService;

/**
 * controller class to direct services
 * 
 * @author surbhiagarwal
 *
 */
@RestController
@RequestMapping("/direct-req")
public class DirectOrderRequestController {

	@Autowired
	private DirectOrderService directOrderService;

	/**
	 * adds new service providers
	 * 
	 * @param serviceProvider
	 */
	@RequestMapping(value = "/add-serviceprovider", method = RequestMethod.POST)
	private void addNewServiceProvider(@RequestBody ServiceProvider serviceProvider) {
		directOrderService.addToList(serviceProvider);
	}

	/**
	 * gets all service providers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getAllServiceProviders")
	private List<ServiceProvider> getAllServiceProviders() {
		List<ServiceProvider> list = directOrderService.getAllServiceProviders();
		return list;
	}

	/**
	 * request available service providers for a service
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/requestServiceProviders", method = RequestMethod.POST)
	private List<ServiceProvider> requestServiceProviders(@RequestBody OrderRequest req) {
		List<ServiceProvider> serviceProviders = directOrderService.getSpecifiedServiceProviders(req);
		return serviceProviders;
	}

}
