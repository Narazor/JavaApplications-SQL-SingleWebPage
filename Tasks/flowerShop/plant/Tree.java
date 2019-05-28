package ua.flowerShop.plant;

public class Tree extends Plant {

	private boolean presenceOfFruits;

	public Tree(String nameOfGoods, String type, int price, PlantSize size, boolean presenceOfFruits) {
		super(nameOfGoods, type, price, size);
		this.presenceOfFruits = presenceOfFruits;
	}

	public boolean getPresenceOfFruits() {
		return presenceOfFruits;
	}

	@Override
	public String toString() {
		return getType() + "(" + getSize() + ") price = " + getPrice() + ", the presence of fruits - "
				+ getPresenceOfFruits();
	}

}
