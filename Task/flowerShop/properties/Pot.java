package ua.flowerShop.properties;

import ua.flowerShop.enums.Size;

public class Pot {

	private String material;
	private Size sizeOfPot;
	
	public Pot(String material, Size sizeOfPot) {
		this.material = material;
		this.sizeOfPot = sizeOfPot;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public Size getSizeOfPot() {
		return sizeOfPot;
	}

	@Override
	public String toString() {
		return "features of pot (material - " + getMaterial() + ", size - " + getSizeOfPot() + ")";
	}
	
}
