package syst.apigee.com.productservices.apiModel;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.util.StringUtils;

public class APIProduct implements Comparable<APIProduct> {

	private String productId;
	private String title;
	private APIColorSwatch[] colorSwatches;
	private APIPrice price;

	public APIPrice getPrice() {
		return price;
	}

	public void setPrice(APIPrice price) {
		this.price = price;
	}

	public APIColorSwatch[] getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(APIColorSwatch[] colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "APIProduct [productId=" + productId + ", title=" + title + ", colorSwatches="
				+ Arrays.toString(colorSwatches) + ", price=" + price + "]";
	}

	@Override
	public int compareTo(APIProduct o) {
		if (StringUtils.isEmpty(this.getPrice().getWas()) || StringUtils.isEmpty(this.getPrice().getNow().textValue())) {
			return 0;
		}
		if (StringUtils.isEmpty(o.getPrice().getWas()) || StringUtils.isEmpty(o.getPrice().getNow().textValue())) {
			return 0;
		}
		BigDecimal thisReduction = new BigDecimal(this.getPrice().getWas())
				.subtract(new BigDecimal(this.getPrice().getNow().textValue()));
		BigDecimal otherReduction = new BigDecimal(o.getPrice().getWas())
				.subtract(new BigDecimal(o.getPrice().getNow().textValue()));
		return thisReduction.compareTo(otherReduction);
	}

}
