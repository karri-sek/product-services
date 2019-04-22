package syst.apigee.com.productservices.util;

import java.util.HashMap;

public class ColorMapUtil {
	
	private static HashMap<String, String> colorHexMap;
	
	static {
		colorHexMap = new HashMap<String,String>();
		colorHexMap.put("Black", "000000");
		colorHexMap.put("Red", "FF0000");
		colorHexMap.put("Maroon", "800000");
		colorHexMap.put("Yellow", "FFFF00");
		colorHexMap.put("Grey", "808080");
		colorHexMap.put("Silver", "C0C0C0");
		colorHexMap.put("Green", "008000");
		colorHexMap.put("Orange", "FFA500");
		colorHexMap.put("Blue", "0000FF");
		colorHexMap.put("Multi", "B22222");
		colorHexMap.put("Purple", "800080");
		colorHexMap.put("Violet", "EE82EE");
		colorHexMap.put("Washed Black", "EG82FE");
		colorHexMap.put("Grey Marl", "HJF4HJK");
		colorHexMap.put("Ice Grey Retro Spot", "04JD8K");
		colorHexMap.put("Hibiscus", "94JKL0");
		
	}
	
	public static String getColorHexaCode(String color) {
		return colorHexMap.get(color);
	}
	
	
	

}
