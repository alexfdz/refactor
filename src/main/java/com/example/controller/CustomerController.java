package com.example.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.example.service.GeoResultsService;
import com.example.service.impl.DummyGeoResultsImpl;

public class CustomerController
{

    public String DEFAULT_CS_NUMBER = "999999";

    /**
     * Produce customer service phone numbers from Geo results stored in the HTTP session. Each geographic region has its' zero or more customer service phone numbers. It is
     * possible to show more than one phone number. If there is no phone number associated a default phone number is used.
     */
    public String getCustomerServicePhoneNumber(HttpSession session)
    {

        String phoneNumber = "";
        GeoResultsService result = (GeoResultsService) session.getAttribute(DummyGeoResultsImpl.GeoResults_KEY);

        if (result != null)
        {

            Set phoneNumbers = result.getCustomerServicePhoneNumbers();

            if (phoneNumbers != null)
            {

                for (Object string : phoneNumbers)
                {
                    phoneNumber += phoneNumbers.iterator().next();
                }
            }
            else
            {
                Logger.getLogger(this.getClass()).warn("No customer service numbers found.");
                phoneNumber = DEFAULT_CS_NUMBER;
            }
        }

        return phoneNumber;
    }
}