package com.example.controller;

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
		String result = controller.getCustomerServicePhoneNumber(null);
		Assert.assertNotNull(result);
		Assert.assertSame(controller.getDefaultCSNumber(), result);
		
		result = controller.getCustomerServicePhoneNumber("dummyRegion");
		Assert.assertNotNull(result);
		Assert.assertNotSame(controller.getDefaultCSNumber(), result);
	}
}
