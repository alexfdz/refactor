package com.example.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.model.CustomerServicePhoneNumbers;
import com.example.service.GeoResultsService;
import com.example.service.impl.DummyGeoResultsImpl;

@Controller
public class CustomerController
{
	private static final Logger logger = Logger.getLogger(CustomerController.class);

    public static final String DEFAULT_CS_NUMBER = "999999";
    public static final String REGION_KEY = "regionKey";
    
    @Autowired
    private GeoResultsService geoResultsService;

    public String getCustomerServicePhoneNumber(HttpSession session){
    	String regionId = null;
    	String phoneNumber = DEFAULT_CS_NUMBER;
    	
    	if(session != null && session.getAttribute(REGION_KEY) instanceof String){
    		regionId =  (String)session.getAttribute(REGION_KEY);
    	}else{
    		logger.warn("No region found.");
    		return phoneNumber;
    	}
    	
    	if(StringUtils.isNotEmpty(regionId)){
    		CustomerServicePhoneNumbers phoneNumbers = geoResultsService.getCustomerServicePhoneNumbers(regionId);
    		if(phoneNumbers != null && phoneNumbers.getPhoneNumbers() != null){
    			phoneNumber = StringUtils.join(phoneNumbers.getPhoneNumbers(), null);
    		}else{
    			logger.warn("No customer service numbers found.");
    		}
    	}else{
    		logger.warn("No region found.");
    	}
    
        return phoneNumber;
    }
}