package ua.flowerShop.plant;

public class Flowerpot extends Plant {

	private String potMaterial;

	public Flowerpot(String nameOfGoods, String type, int price, PlantSize size, String potMaterial) {
		super(nameOfGoods, type, price, size);
		this.potMaterial = potMaterial;
	}

	public String getPotMaterial() {
		return potMaterial;
	}

	@Override
	public String toString() {
		return getNameOfGoods() + ": " +getType() + "(" + getSize() + "), price = " + getPrice() + ", pot material - " + getPotMaterial();
	}

}
