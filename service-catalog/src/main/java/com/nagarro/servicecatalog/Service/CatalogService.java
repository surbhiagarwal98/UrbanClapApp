package com.nagarro.servicecatalog.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.nagarro.servicecatalog.model.UrbanService;

/**
 * implements the services needed for catalog
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class CatalogService {

	List<UrbanService> services = new ArrayList<UrbanService>();

	public List<UrbanService> getServiceCatalog() {
		services.add(new UrbanService(1, "Interior Design", "4",
				Stream.of("Gurugram", "Noida").collect(Collectors.toCollection(ArrayList::new))));
		services.add(new UrbanService(2, "Yoga Training", "5",
				Stream.of("Gurugram", "Noida", "Ghaziabad").collect(Collectors.toCollection(ArrayList::new))));
		services.add(new UrbanService(3, "House Cleaning", "3",
				Stream.of("Gurugram", "Delhi", "Meerut").collect(Collectors.toCollection(ArrayList::new))));
		services.add(new UrbanService(4, "Chef", "4",
				Stream.of("Delhi", "Noida", "Ghaziabad").collect(Collectors.toCollection(ArrayList::new))));

		return services;
	}

}
