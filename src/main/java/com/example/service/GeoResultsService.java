package com.example.service;

import com.example.model.CustomerServicePhoneNumbers;

public interface GeoResultsService
{
	public CustomerServicePhoneNumbers getCustomerServicePhoneNumbers(
			String regionId);
}
