package ua.flowerShop.plant;

public class Flower extends Plant {

	private String color;

	public Flower(String nameOfGoods, String type, int price, PlantSize size, String color) {
		super(nameOfGoods, type, price, size);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return getNameOfGoods() + ": " + getColor() + " " + getType() + "(" + getSize() + "), price per flower = " + getPrice()
				+ "hrn.";
	}

}
