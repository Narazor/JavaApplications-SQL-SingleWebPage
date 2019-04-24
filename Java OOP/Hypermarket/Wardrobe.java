package ua.myHypermarket;

public class Wardrobe extends WoodenProduct {

	public Wardrobe(String name, String producer, int price, int count, boolean insurancee) {
		super(name, producer, price, count, insurancee);
	}


	@Override
	public String getNameOfProduct() {
		return "wardrobes";
	}

}
