package syst.apigee.com.productservices.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.util.StringUtils;

import syst.apigee.com.productservices.apiModel.APIPrice;

public class PriceUtils {

	private static BigDecimal compare = new BigDecimal("10.00");

	public static String getPrice(String price) {
		price = (price == null || price == "") ? "0.00" : price;
		BigDecimal value = new BigDecimal(price);
		if (value.compareTo(compare) == 1) {
			return "£" + value.intValue();
		} else {
			return "£" + value;
		}
	}

	public static String getPriceLabel(String labelType, APIPrice price) {
		String wasValue = price.getWas();
		String nowValue = price.getNow().textValue();
		switch (labelType) {
		case "ShowWasThenNow": {
			return "Was " + getPrice(wasValue) + getThenPriceString(price) + ", now " + getPrice(nowValue);
		}
		case "ShowPercDscount": {
			return getPercentageDiscount(price) + "% off - now " + getPrice(nowValue);
		}
		default: {
			return "Was " + getPrice(wasValue) + ", now " + getPrice(nowValue);
		}
		}
	}

	public static String getThenPriceString(APIPrice price) {
		if (price.getThen2() != null && price.getThen2() != "") {
			return ", then " + getPrice(price.getThen2());
		} else if (price.getThen1() != null && price.getThen1() != "") {
			return ", then " + getPrice(price.getThen1());
		} else {
			return "";
		}
	}

	public static String getPercentageDiscount(APIPrice price) {
		if (StringUtils.isEmpty(price.getWas()) || StringUtils.isEmpty(price.getNow().textValue())) {
			return "0";
		} else {
			String was = price.getWas();
			String now = price.getNow().textValue();
			BigDecimal difference = new BigDecimal(was).subtract(new BigDecimal(now));
			BigDecimal diff = difference.divide(new BigDecimal(was), 4, RoundingMode.CEILING);
			BigDecimal percentage = diff.multiply(new BigDecimal("100"));
			return percentage.setScale(1, RoundingMode.CEILING).toString();
		}
	}

	public static boolean isReductionInPrice(APIPrice price) {
		if (StringUtils.isEmpty(price.getWas()) || StringUtils.isEmpty(price.getNow().textValue())) {
			return false;
		} else {
			BigDecimal was = new BigDecimal(price.getWas());
			BigDecimal now = new BigDecimal(price.getNow().textValue());
			if (was.compareTo(now) == 1) {
				return true;
			} else {
				return false;
			}
		}
	}

}
