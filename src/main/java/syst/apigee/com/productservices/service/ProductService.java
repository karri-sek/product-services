package syst.apigee.com.productservices.service;

import java.util.List;

import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.model.Product;

public interface ProductService {
	
	public List<Product> getProducts(List<APIProduct> apiProducts, String labelType);

}
