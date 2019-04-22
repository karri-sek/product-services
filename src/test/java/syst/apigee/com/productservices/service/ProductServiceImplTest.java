package syst.apigee.com.productservices.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.model.Product;
import syst.apigee.com.productservices.service.impl.ApigeeServiceImpl;
import syst.apigee.com.productservices.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private ApigeeService apigeeService;

	List<APIProduct> apiProducts;

	@Before
	public void setup() {
		productService = new ProductServiceImpl();
		apigeeService = new ApigeeServiceImpl();
		apiProducts = apigeeService.getApigeeProducts();
	}

	@Test
	public void shouldBeAbletoGetProducts() throws Exception {
		List<Product> products = productService.getProducts(apiProducts, "ShowPercDscount");
		assertTrue(products.size() > 0);
	}

	@Test
	public void productShouldHaveSomeDetails() throws Exception {
		List<Product> products = productService.getProducts(apiProducts, "ShowWasThenNow");
		Product product = products.get(0);
		assertTrue(product.getProductId() != "");
		assertTrue(product.getTitle() != "");
	}
	
	@Test
	public void productShouldHaveAllDetails() throws Exception {
		List<Product> products = productService.getProducts(apiProducts, "ShowWasThenNow");
		Product product = products.get(0);
		assertTrue(product.getProductId() != "");
		assertTrue(product.getTitle() != "");
		assertTrue(product.getColorSwatches() != null);
		assertTrue(product.getNowPrice() != "");
		assertTrue(product.getNowPrice()!= "");
	}
}
