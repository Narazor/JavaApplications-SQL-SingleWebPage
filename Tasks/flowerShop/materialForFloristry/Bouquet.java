package ua.flowerShop.materialForFloristry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.flowerShop.*;
import ua.flowerShop.plant.*;

public class Bouquet extends Product {

	private List<Flower> flowers;
	private Tape tape;
	private WrapperBouquet wrapper;

	public Bouquet(String nameOfGoods, List<Flower> flowers, Tape tape, WrapperBouquet wrapper) {
		super(nameOfGoods);
		this.flowers = flowers;
		this.tape = tape;
		this.wrapper = wrapper;
		setPrice(calcPriceOfBouquet());
	}

	// The method calculates price a bouquet with all necessary detail
	private int calcPriceOfBouquet() {
		int price = 0;
		for (Flower f : flowers) {
			price += f.getPrice();
		}
		return price + wrapper.getPrice() + tape.getPrice();
	}

	// The method returns a color of flower + type and number of flowers in the
	// bouquet
	private Map<String, Integer> calculateNumberOfFlowers() {
		Map<String, Integer> numberOfFlowers = new HashMap<String, Integer>();
		for (Flower p : flowers) {
			int count = 1;
			if (numberOfFlowers.containsKey(p.getColor() + " " + p.getType())) {
				count += numberOfFlowers.get(p.getColor() + " " + p.getType());
			}
			numberOfFlowers.put(p.getColor() + " " + p.getType(), count);
		}
		return numberOfFlowers;
	}

	@Override
	public String toString() {
		return "[" + getNameOfGoods() + ": " + tape + " + " + wrapper + " + " + calculateNumberOfFlowers()
				+ " - price = " + getPrice() + "hrn]";
	}

}
