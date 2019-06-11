package ua.flowerShop.decorator;

import ua.flowerShop.product.Product;

public class PaperDecorator extends BouquetDecorator {
	
	private final int PAPER_PRICE = 10;
	private Product product;
	
	public PaperDecorator(Product product) {
		this.product = product;
	}
	
	@Override
	public double getPrice() {
		return PAPER_PRICE + product.getPrice();
	}
	
	@Override
	public String getDescription() {
		return "Paper for bouquet";
	}
	
	@Override
	public String toString() {
		return getDescription() + "(" + PAPER_PRICE + "hrn) + " + product;
	}


	
}
