package syst.apigee.com.productservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import syst.apigee.com.productservices.apiModel.APIProduct;

public class RestResponse {
	
	@JsonProperty
	private List<APIProduct> products;
	
	public List<APIProduct> getProducts() {
		return products;
	}

}
