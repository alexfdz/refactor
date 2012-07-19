package com.example.service.impl;

import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.mockito.Mockito;

import com.example.model.CustomerServicePhoneNumbers;
import com.example.service.GeoResultsService;

public class DummyGeoResultsImpl implements GeoResultsService
{
	/* (non-Javadoc)
	 * @see com.example.service.GeoResultsService#getCustomerServicePhoneNumbers(java.lang.String)
	 */
	@Override
	@SuppressWarnings("serial")
	public CustomerServicePhoneNumbers getCustomerServicePhoneNumbers(
			String regionId) {
		//Dummy results
		CustomerServicePhoneNumbers result = Mockito.mock(CustomerServicePhoneNumbers.class);
		if(StringUtils.isNotEmpty(regionId)){
			Mockito.when(result.getPhoneNumbers()).thenReturn(new HashSet<String>(){{
	            add("123456");
	            add("654321");
	            add("948737");
	        }});
		}
		return result;
	}
}
