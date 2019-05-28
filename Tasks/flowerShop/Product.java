package ua.flowerShop;

public abstract class Product {
	// The abstract class describes all properties goods

	private String nameOfGoods;
	private String type;
	private int price;

	public Product(String nameOfGoods, String type, int price) {
		this.type = type;
		this.price = price;
		this.nameOfGoods = nameOfGoods;
	}

	public Product(String nameOfGoods) {
		this.nameOfGoods = nameOfGoods;
	}

	public String getNameOfGoods() {
		return nameOfGoods;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
