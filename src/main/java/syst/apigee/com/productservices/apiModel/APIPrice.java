package syst.apigee.com.productservices.apiModel;

import com.fasterxml.jackson.databind.JsonNode;

public class APIPrice {
	
	private String was;
	private String then1;
	private String then2;
	private String uom;
	private JsonNode now;
	private String currency;
	
	public JsonNode getNow() {
		return now;
	}
	public void setNow(JsonNode now) {
		this.now = now;
	}
	public String getWas() {
		return was;
	}
	public void setWas(String was) {
		this.was = was;
	}
	public String getThen1() {
		return then1;
	}
	public void setThen1(String then1) {
		this.then1 = then1;
	}
	public String getThen2() {
		return then2;
	}
	public void setThen2(String then2) {
		this.then2 = then2;
	}
	
	
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "APIPrice [was=" + was + ", then1=" + then1 + ", then2=" + then2 + ", uom=" + uom + ", currency="
				+ currency + "]";
	}
	

}
