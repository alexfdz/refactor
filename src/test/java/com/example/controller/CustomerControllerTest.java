package com.example.controller;

import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerControllerTest {

	@Test
	public void testGetCustomerServicePhoneNumber(){
		CustomerController controller = new CustomerController();
		HttpSession session = Mockito.mock(HttpSession.class);
		
		String result = controller.getCustomerServicePhoneNumber(session);
		Assert.assertNotNull(result);
		Assert.assertSame(CustomerController.DEFAULT_CS_NUMBER, result);
		
		result = controller.getCustomerServicePhoneNumber(null);
		Assert.assertNotNull(result);
		Assert.assertSame(CustomerController.DEFAULT_CS_NUMBER, result);
		
		Mockito.when(session.getAttribute(Mockito.anyString())).thenReturn("dummyRegion");
		result = controller.getCustomerServicePhoneNumber(session);
		Assert.assertNotNull(result);
		Assert.assertNotSame(CustomerController.DEFAULT_CS_NUMBER, result);
	}
}
