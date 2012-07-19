package com.example.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.example.service.GeoResultsService;

public class DummyGeoResultsImpl implements GeoResultsService
{
    public static String GeoResults_KEY ="geo_key";

    public Set getCustomerServicePhoneNumbers()
    {
        Set phoneNumbers = new HashSet();

        phoneNumbers.add("123456");
        phoneNumbers.add("654321");
        phoneNumbers.add("948737");

        return phoneNumbers;
    }
}
