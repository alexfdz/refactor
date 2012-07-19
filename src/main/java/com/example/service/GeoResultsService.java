package com.example.service;

import com.example.model.CustomerServicePhoneNumbers;

public interface GeoResultsService
{
	/**
	 * Resolves the {@link CustomerServicePhoneNumbers} entity for a given region
	 * @param regionId
	 * @return null if it can't find the service phone numbers
	 */
	public CustomerServicePhoneNumbers getCustomerServicePhoneNumbers(
			String regionId);
}
