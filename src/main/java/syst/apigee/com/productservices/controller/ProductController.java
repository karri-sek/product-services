package syst.apigee.com.productservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.apiModel.ResponseEntity;
import syst.apigee.com.productservices.service.ApigeeService;
import syst.apigee.com.productservices.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ApigeeService apigeeService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity getProducts(@RequestParam(defaultValue = "ShowWasNow") Optional<String> labelType) {
		ResponseEntity responseEntity = new ResponseEntity();
		
		List<APIProduct> apiProducts = apigeeService.getApigeeProducts();	
		
		responseEntity.setProducts(productService.getProducts(apiProducts, labelType.get()));
		return responseEntity;
	}
}
