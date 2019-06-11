package ua.flowerShop.product;

import ua.flowerShop.properties.PropertyFlower;

public class Flower extends Product {

	private PropertyFlower properties;
	
	public Flower(String description, PropertyFlower properties) {
		super(description);
		this.properties = properties;
	}
	
	// The method returns the price, which depends on the given properties of the flower
	@Override
	public double getPrice() {
		return properties.getPrice();
	}

	@Override
	public String toString() {
		return getDescription() + ": " + properties +", price = "+ getPrice() + "hrn!";
	}



	
	

}
