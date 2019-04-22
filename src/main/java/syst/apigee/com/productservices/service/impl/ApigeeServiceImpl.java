package syst.apigee.com.productservices.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.model.RestResponse;
import syst.apigee.com.productservices.service.ApigeeService;

@Service
public class ApigeeServiceImpl implements ApigeeService {
	final String apiUri = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	@Override
	public List<APIProduct> getApigeeProducts() {
		RestTemplate restTemplate = new RestTemplate();
		RestResponse restResponse = restTemplate.getForObject(apiUri, RestResponse.class);
		return restResponse.getProducts();
	}
}
