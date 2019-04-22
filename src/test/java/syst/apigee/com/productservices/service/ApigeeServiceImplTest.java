package syst.apigee.com.productservices.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.service.impl.ApigeeServiceImpl;

public class ApigeeServiceImplTest {

	@Autowired
	private ApigeeService apigeeService;

	@Before
	public void setup() {
		apigeeService = new ApigeeServiceImpl();
	}

	@Test
	public void shouldBeAbleToReachApiGeeAPI() throws Exception {
		List<APIProduct> apiProducts = apigeeService.getApigeeProducts();
		assertTrue(apiProducts.size()>0);
	}
	
	@Test
	public void ApiProductShouldHaveSomeDetails() throws Exception {
		List<APIProduct> apiProducts = apigeeService.getApigeeProducts();
		APIProduct apiProduct = apiProducts.get(0);
		assertTrue(apiProduct.getProductId() !="");
		assertTrue(apiProduct.getTitle() !="");
	}

}
