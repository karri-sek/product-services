package syst.apigee.com.productservices.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import syst.apigee.com.productservices.apiModel.APIColorSwatch;
import syst.apigee.com.productservices.apiModel.APIProduct;
import syst.apigee.com.productservices.model.ColorSwatch;
import syst.apigee.com.productservices.model.Product;
import syst.apigee.com.productservices.service.ProductService;
import syst.apigee.com.productservices.util.ColorMapUtil;
import syst.apigee.com.productservices.util.PriceUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> getProducts(List<APIProduct> apiProducts, String labelType) {
		List<Product> listOfProducts = new ArrayList<>();
		Collections.sort(apiProducts);
		apiProducts.stream().filter(p->PriceUtils.isReductionInPrice(p.getPrice())).forEach(apiProduct ->{
			Product product = new Product();
			product.setNowPrice(PriceUtils.getPrice(apiProduct.getPrice().getNow().textValue()));
			product.setPriceLabel(PriceUtils.getPriceLabel(labelType, apiProduct.getPrice()));
			product.setProductId(apiProduct.getProductId());
			product.setTitle(apiProduct.getTitle());
			product.setColorSwatches(getColorSwatches(apiProduct.getColorSwatches()));
			listOfProducts.add(product);
		});
		return listOfProducts;
	}

	private List<ColorSwatch>  getColorSwatches(APIColorSwatch[] apiColorSwatches) {
		List<ColorSwatch> listOfColorSwatches = new ArrayList<>();
		for (APIColorSwatch colorSwatch : apiColorSwatches) {
			ColorSwatch swatch = new ColorSwatch();
			swatch.setColor(colorSwatch.getColor());
			swatch.setSkuId(colorSwatch.getSkuId());
			swatch.setRgbColor(ColorMapUtil.getColorHexaCode(colorSwatch.getColor()));
			listOfColorSwatches.add(swatch);
		}
		return listOfColorSwatches;
	}

}
