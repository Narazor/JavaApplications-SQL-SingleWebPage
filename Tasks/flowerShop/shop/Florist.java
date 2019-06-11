package ua.flowerShop.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.flowerShop.decorator.PaperDecorator;
import ua.flowerShop.decorator.RibbonDecorator;
import ua.flowerShop.exception.EnteringDateException;
import ua.flowerShop.product.Flower;
import ua.flowerShop.product.Product;

public class Florist {

	private FlowerShop shop = new FlowerShop();

	// The method creates predefined flowers, determines their amount and returns an
	// array of these flowers
	public Flower[] createSpecifiedInstancesOfFlowers(int numberOfFlowers, Flower flower) {
		Flower[] flowers = new Flower[numberOfFlowers];
		for (int i = 0; i < numberOfFlowers; i++) {
			flowers[i] = flower;
		}
		return flowers;
	}

	// The method takes arrays of flowers and converts them into the only list
	// which will form a user's bouquet
	public List<Flower> convertListArraysOfFlowers(List<Flower[]> flower) {
		List<Flower> flowers = new ArrayList<Flower>();
		for (Flower[] f : flower) {
			flowers.addAll(Arrays.asList(f));
		}
		return flowers;
	}

	// The method asks user what type of flowers and how many flowers he wants in
	// his bouquet, if user inputs date incorrect the method throws exception
	public Flower[] getSpecifiedInstancesOfFlowers(String flower, int numberOfFlowers) throws EnteringDateException {
		for (Product p : shop.getAllGoods()) {
			if (p instanceof Flower) {
				if (flower.equals(p.getDescription())) {
					return createSpecifiedInstancesOfFlowers(numberOfFlowers, (Flower) p);
				}
			}
		}
		throw new EnteringDateException(
				"You can choose only red /white rose OR red /white /yellow tulip OR chamomile OR white /yellow /purple /blue chrysanthemum");
	}

	// The method return a product name, which user inputed
	public Product getSpecifiedProduct(String nameProduct) throws EnteringDateException {
		for (Product product : shop.getAllGoods()) {
			if (nameProduct.equalsIgnoreCase(product.getDescription())) {
				return product;
			}
		}
		throw new EnteringDateException("Incorect input. Try again!");
	}

	// The method creates a bouquet with a decoration that the user has chosen
	public Product getBouquet(Product setOfFlowers, String decorator) throws EnteringDateException {
		switch (decorator.toLowerCase()) {
		case "with ribbon":
			return new RibbonDecorator(setOfFlowers);
		case "with paper and ribbon":
			return new PaperDecorator(new RibbonDecorator(setOfFlowers));
		case "only flowers":
			return setOfFlowers;
		}
		throw new EnteringDateException("Incorect input. Try again!");
	}

}
