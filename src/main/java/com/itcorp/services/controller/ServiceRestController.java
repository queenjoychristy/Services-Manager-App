package com.itcorp.services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itcorp.services.entity.ServiceEntity;
import com.itcorp.services.error.ErrorUtils;
import com.itcorp.services.repository.ServiceRepository;

@RestController
public class ServiceRestController {

	private ServiceRepository repository = new ServiceRepository();
	
	@RequestMapping(value = "/services", method = RequestMethod.GET)
	public List<ServiceEntity> getAllServices() {
		
		return repository.listAll();
	}

	@RequestMapping(value = "/services/{serviceCode}", method = RequestMethod.GET)
	public ServiceEntity getServiceByCode(@PathVariable("serviceCode") String serviceCode) {
		
		ServiceEntity serviceEntityObj = repository.findByCode(serviceCode);		
		ErrorUtils.checkForInvalidServiceCode(serviceEntityObj, serviceCode);
		
		return serviceEntityObj;		
	}
		
}
