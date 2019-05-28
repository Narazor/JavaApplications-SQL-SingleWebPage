package ua.flowerShop.materialForFloristry;

import ua.flowerShop.Product;

public class WrapperBouquet extends Product {
	
	public WrapperBouquet(String nameOfGoods, String type, int price) {
		super(nameOfGoods, type, price);
	}
	
	@Override
	public String toString() {
		return getNameOfGoods() + "("  + getType() + ", price = " + getPrice() + "hrn)";
	}

}
