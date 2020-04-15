package com.example.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration getLimits() {
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
	}
	
	@GetMapping("/fault-tollerence-example")
	@HystrixCommand(fallbackMethod = "fallbackRetriveConfiguration")
	public LimitConfiguration retriveConfiguration() {
		throw new RuntimeException("Not Avaailable");
	}
	
	public LimitConfiguration fallbackRetriveConfiguration() {
		return new LimitConfiguration(9999, 9);
	}

}
