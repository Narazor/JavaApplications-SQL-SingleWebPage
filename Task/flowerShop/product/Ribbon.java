package ua.flowerShop.product;
public class Ribbon extends Product {
	
	private String type;
	
	public Ribbon(String description, String type) {
		super(description);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public double getPrice() {
		return 5;
	}

	@Override
	public String toString() {
		return getDescription() + ", type -  " + getType() + ", price = " + getPrice() + "hrn!";
	}
	
	

}
