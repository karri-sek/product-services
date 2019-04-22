package syst.apigee.com.productservices.apiModel;

import java.util.List;

import syst.apigee.com.productservices.model.Product;

public class ResponseEntity {

	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ResponseEntity [products=" + products + "]";
	}
}
