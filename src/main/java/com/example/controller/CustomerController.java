package com.example.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.CustomerServicePhoneNumbers;
import com.example.service.GeoResultsService;

@Controller
public class CustomerController
{

	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
    private @Value("${defaultCustomerServiceNumber}") String defaultCSNumber;
    
    @Autowired
    private GeoResultsService geoResultsService;
    

    /**
     * Produce customer service phone numbers for a given region Id. Each geographic region has its' zero or more customer service phone numbers. It is
     * possible to show more than one phone number. If there is no phone number associated a default phone number is used.
     */
    public @ResponseBody String getCustomerServicePhoneNumber(@RequestParam String regionId) {
        String phoneNumber;
        
        CustomerServicePhoneNumbers phoneNumbers = geoResultsService.getCustomerServicePhoneNumbers(regionId);
        if(phoneNumbers != null && !phoneNumbers.getPhoneNumbers().isEmpty()){
        	phoneNumber = StringUtils.join(phoneNumbers.getPhoneNumbers(), null);
        }else{
        	logger.warn("No customer service numbers found.");
        	phoneNumber = defaultCSNumber;
        }
        return phoneNumber;
    }

	public String getDefaultCSNumber() {
		return defaultCSNumber;
	}
}