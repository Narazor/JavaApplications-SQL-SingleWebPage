package ua.flowerShop.product;
public abstract class Product {

	private String description;
	
	public Product(String description) {
		this.description = description;
	}
	
	public Product() {
		
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract double getPrice();
	
}
