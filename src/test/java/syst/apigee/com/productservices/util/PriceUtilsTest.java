package syst.apigee.com.productservices.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import syst.apigee.com.productservices.apiModel.APIPrice;

public class PriceUtilsTest {
	
	APIPrice apiPrice;

	@Before
	public void setup() {
		apiPrice = new APIPrice();
	}

	@Test
	public void shouldBeAbleToGetThePriceInFormat() throws Exception {
		assertEquals(PriceUtils.getPrice("70.00"), "£70");
	}

	@Test
	public void equalTo10ShouldBeInDesiredFormat() throws Exception {
		assertEquals(PriceUtils.getPrice("10.00"), "£10.00");
	}

	@Test
	public void equalTo100InDesiredFormat() throws Exception {
		assertEquals(PriceUtils.getPrice("100"), "£100");
	}

	@Test
	public void lessThen10ValueShouldBeInDesiredFormat() throws Exception {
		assertEquals(PriceUtils.getPrice("2.68"), "£2.68");
	}

	@Test
	public void shouldBeAbleToGetPriceLabelWithShowWasNow() throws Exception {
		String jsonString = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String labelType = PriceUtils.getPriceLabel("ShowWasNow", apiPrice);
		assertEquals(labelType, "Was £0.00, now £59");
	}

	@Test
	public void shouldBeAbleToGetPriceLabelWithShowWasThenNow() throws Exception {
		String jsonString = "{\"was\":\"80.00\",\"then1\":\"60.00\",\"then2\":\"\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String labelType = PriceUtils.getPriceLabel("ShowWasThenNow", apiPrice);
		assertEquals(labelType, "Was £80, then £60, now £59");
	}

	@Test
	public void ShouldBeAbleToGetPercentageDiscount() throws Exception {
		String jsonString = "{\"was\":\"99.00\",\"then1\":\"75.00\",\"then2\":\"63.75\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String percentage = PriceUtils.getPercentageDiscount(apiPrice);
		assertEquals(percentage, "40.5");
	}

	@Test
	public void ShouldBeAbleToGetPercentageDiscountWithEmptyValues() throws Exception {
		String jsonString = "{\"was\":\"\",\"then1\":\"75.00\",\"then2\":\"63.75\",\"now\":\"\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String percentage = PriceUtils.getPercentageDiscount(apiPrice);
		assertEquals(percentage, "0");
	}

	@Test
	public void shouldBeAbleToGetPercentageInDscount() throws Exception
	{
		String jsonString = "{\"was\":\"80.00\",\"then1\":\"60.00\",\"then2\":\"\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String labelType = PriceUtils.getPriceLabel("ShowPercDscount", apiPrice);
		assertEquals(labelType, "26.3% off - now £59");
	}
	
	@Test
	public void shouldBeAbleToGetZeroPercentageInDscount() throws Exception
	{
		String jsonString = "{\"was\":\"\",\"then1\":\"75.00\",\"then2\":\"63.75\",\"now\":\"\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String labelType = PriceUtils.getPriceLabel("ShowPercDscount", apiPrice);
		assertEquals(labelType, "0% off - now £0.00");
	}
	
	@Test
	public void shouldBeAbleToGetPercentageInDscountWithValues() throws Exception
	{
		String jsonString = "{\"was\":\"99.00\",\"then1\":\"75.00\",\"then2\":\"63.75\",\"now\":\"59.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
		APIPrice apiPrice = new ObjectMapper().readValue(jsonString, APIPrice.class);
		String labelType = PriceUtils.getPriceLabel("ShowPercDscount", apiPrice);
		assertEquals(labelType, "40.5% off - now £59");
	}

}
