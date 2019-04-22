package syst.apigee.com.productservices.model;

public class ColorSwatch {
	
	private String color;
	private String rgbColor;
    public String getRgbColor() {
		return rgbColor;
	}

	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}

	private String skuId;
    
    
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	
	@Override
	public String toString() {
		return "ColorSwatch [color=" + color + ", rgbColor=" + rgbColor + ", skuId=" + skuId + "]";
	}

}
