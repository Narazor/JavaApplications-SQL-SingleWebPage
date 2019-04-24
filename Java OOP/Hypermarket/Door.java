package ua.myHypermarket;

public class Door extends WoodenProduct {

	public Door(String name, String producer, int price, int count, boolean insurancee) {
		super(name, producer, price, count, insurancee);
	}

	@Override
	public String getNameOfProduct() {
		return "door";
	}
}
