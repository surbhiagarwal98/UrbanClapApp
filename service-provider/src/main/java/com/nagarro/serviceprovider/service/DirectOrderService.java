package com.nagarro.serviceprovider.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.serviceprovider.model.OrderRequest;
import com.nagarro.serviceprovider.model.ServiceProvider;

/**
 * directs order request coming from admin
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class DirectOrderService {

	List<ServiceProvider> serviceProviders = Arrays.asList(new ServiceProvider("shdjsd", "Abc", "Noida", 1,
			"+91 7983975574", "surbhiagarwal219@gmail.com", "Yes", null));

	/**
	 * adds new service providers
	 * 
	 * @param serviceProvider
	 */
	public void addToList(ServiceProvider serviceProvider) {
		serviceProviders.add(serviceProvider);
	}

	/**
	 * gets all service providers
	 * 
	 * @return
	 */
	public List<ServiceProvider> getAllServiceProviders() {
		return serviceProviders;
	}

	/**
	 * gets specified services providers to direct request to
	 * 
	 * @param req
	 * @return
	 */
	public List<ServiceProvider> getSpecifiedServiceProviders(OrderRequest req) {
		List<ServiceProvider> specifiedServiceProviders = new ArrayList<ServiceProvider>();
		int serviceId = req.getorder().getRequestedServiceId();
		for (ServiceProvider sp : serviceProviders) {
			if (sp.getServiceId() == serviceId) {
				specifiedServiceProviders.add(sp);
			}
		}
		return specifiedServiceProviders;
	}

}
