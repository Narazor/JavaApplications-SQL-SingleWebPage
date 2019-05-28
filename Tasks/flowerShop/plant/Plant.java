package ua.flowerShop.plant;

import ua.flowerShop.Product;

public abstract class Plant extends Product {
	
	private PlantSize size;

	public Plant(String nameOfGoods, String type, int price, PlantSize size) {
		super(nameOfGoods, type, price);
		this.size = size;
	}
	
	public PlantSize getSize() {
		return size;
	}

}
