package syst.apigee.com.productservices.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorMapUtilTest {

	@Test
	public void shouldBeAbleToGetRGBCodeForBlack() throws Exception {
		assertEquals(ColorMapUtil.getColorHexaCode("Black"), "000000");
	}
	
	@Test
	public void shouldBeAbleToGetRGBCodeForBlue() throws Exception {
		assertEquals(ColorMapUtil.getColorHexaCode("Blue"), "0000FF");
	}
	
	@Test
	public void shouldBeAbleToGetRGBCodeForRed() throws Exception {
		assertEquals(ColorMapUtil.getColorHexaCode("Red"), "FF0000");
	}
}
