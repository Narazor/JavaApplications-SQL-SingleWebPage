package ua.flowerShop.product;

import ua.flowerShop.properties.Pot;

public class Flowerpot extends Product{
	
	private Pot pot;
	private double price;

	public Flowerpot(String description, Pot pot, double price) {
		super(description);
		this.pot = pot;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getDescription() + ": " + pot + ", price = " + getPrice() + "hrn!";
	}

}
