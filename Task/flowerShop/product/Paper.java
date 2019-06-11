package ua.flowerShop.product;
public class Paper extends Product {
	
	public Paper(String description) {
		super(description);
	}
	
	@Override
	public double getPrice() {
		return 10;
	}

	@Override
	public String toString() {
		return getDescription() + ", price = " + getPrice() + "hrn!";
	}

}
