package ua.flowerShop.decorator;

import ua.flowerShop.product.Product;

public class RibbonDecorator extends BouquetDecorator {
	
	private final int PRICE_RIBBON = 5;
	private Product product;
	
	public RibbonDecorator(Product product) {
		this.product = product;
	}
	
	@Override
	public String getDescription() {
		return "Ribbon for bouquet";
	}
	
	@Override
	public double getPrice() {
		return PRICE_RIBBON + product.getPrice();
	}

	@Override
	public String toString() {
		return getDescription() + "(" + PRICE_RIBBON + "hrn) + " + product;
	}


}
