package syst.apigee.com.productservices.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import syst.apigee.com.productservices.apiModel.ResponseEntity;
import syst.apigee.com.productservices.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldBeAbleToCallAndGetProducts() throws Exception {
		ResponseEntity responseEntity = restTemplate.getForObject("/products", ResponseEntity.class);
		assertTrue(responseEntity.getProducts().size()>0);
	}
	
	@Test
	public void shouldBeAbleToCallAndGetProductsWithQueryParam() throws Exception {
		ResponseEntity responseEntity = restTemplate.getForObject("/products?labelType=ShowPercDscount", ResponseEntity.class);
		Product product = responseEntity.getProducts().get(0);
		assertTrue(responseEntity.getProducts().size()>0);
		assertTrue(product.getPriceLabel().contains("off"));
	}
	
	@Test
	public void shouldBeAbleToCallAndGetProductsWithQueryParamShowWasThenNow() throws Exception {
		ResponseEntity responseEntity = restTemplate.getForObject("/products?labelType=ShowWasThenNow", ResponseEntity.class);
		Product product = responseEntity.getProducts().get(0);
		assertTrue(responseEntity.getProducts().size()>0);
		assertTrue(product.getPriceLabel().contains("Was"));
	}

}
