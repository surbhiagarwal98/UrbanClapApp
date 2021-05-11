package com.nagarro.servicecatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.servicecatalog.Service.CatalogService;
import com.nagarro.servicecatalog.model.UrbanService;

/**
 * shows the list of available sevices in catalog
 * 
 * @author surbhiagarwal
 *
 */
@RestController
@RequestMapping("/catalog")
public class ServiceCatalogResource {

	@Autowired
	private CatalogService catalogService;

	/**
	 * gets available services
	 * 
	 * @return
	 */
	@RequestMapping("/availableservices")
	private List<UrbanService> getServiceCatalog() {
		return catalogService.getServiceCatalog();
	}

	/**
	 * gets service for specific service id
	 * 
	 * @param serviceId
	 * @return
	 */
	@RequestMapping("/{serviceId}")
	private UrbanService getService(@PathVariable("serviceId") int serviceId) {
		UrbanService requestedService = null;
		List<UrbanService> allServices = catalogService.getServiceCatalog();
		for (UrbanService service : allServices) {
			if (serviceId == service.getServiceId()) {
				requestedService = service;
			}
		}

		return requestedService;

	}
}
