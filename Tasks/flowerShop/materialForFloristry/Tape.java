package ua.flowerShop.materialForFloristry;

import ua.flowerShop.Product;

public class Tape extends Product{

	private String color;
	
	public Tape(String nameOfGoods, String type, int price, String color) {
		super(nameOfGoods, type, price);
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return getNameOfGoods() + "(" + getColor() + " " + getType() + ", price = " + getPrice() + "hrn) ";
	}
	
	
	
}
