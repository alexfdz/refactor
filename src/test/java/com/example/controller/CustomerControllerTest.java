package com.example.controller;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/context.xml"})
public class CustomerControllerTest {

	@Autowired
	private CustomerController controller;
	
	@Test
	public void testContext(){
		Assert.assertNotNull(controller);
	}
	
	@Test
	public void testGetCustomerServicePhoneNumber(){
		Set<String> result = controller.getCustomerServicePhoneNumber(null);
		Assert.assertNotNull(result);
		Assert.assertSame(controller.getDefaultCSNumbers(), result);
		Assert.assertSame(1, result.size());
		
		result = controller.getCustomerServicePhoneNumber("dummyRegion");
		Assert.assertNotNull(result);
		Assert.assertNotSame(controller.getDefaultCSNumbers(), result);
		Assert.assertSame(3, result.size());
	}
}
