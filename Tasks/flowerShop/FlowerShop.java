package ua.flowerShop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.flowerShop.materialForFloristry.*;
import ua.flowerShop.plant.*;

public class FlowerShop {

	public List<Product> products = receiveAllProducts();
	public List<Product> basket = new ArrayList<Product>();

	private List<Product> receiveAllProducts() {
		List<Product> goods = new ArrayList<Product>();
		goods.add(new Flower("Flower", "rose", 45, PlantSize.SMALL, "pink"));
		goods.add(new Flower("Flower", "rose", 50, PlantSize.BIG, "red"));
		goods.add(new Flower("Flower", "rose", 50, PlantSize.BIG, "white"));
		goods.add(new Flower("Flower", "tulip", 40, PlantSize.SMALL, "yellow"));
		goods.add(new Flower("Flower", "tulip", 40, PlantSize.SMALL, "red"));
		goods.add(new Flower("Flower", "tulip", 40, PlantSize.SMALL, "purple"));
		goods.add(new Flower("Flower", "chrysanthemum", 40, PlantSize.SMALL, "purple"));
		goods.add(new Flower("Flower", "chrysanthemum", 40, PlantSize.SMALL, "yellow"));
		goods.add(new Flower("Flower", "chrysanthemum", 45, PlantSize.BIG, "white"));
		goods.add(new Flower("Flower", "peony", 35, PlantSize.BIG, "red"));
		goods.add(new Flower("Flower", "peony", 35, PlantSize.BIG, "white"));
		goods.add(createChrysanthemumsMixBouquet());
		goods.add(createRosesMixBouquet());
		goods.add(new Tape("Tape", "decorative", 2, "white"));
		goods.add(new Tape("Tape", "brilliant", 2, "blue"));
		goods.add(new Tape("Tape", "matt", 3, "yellow"));
		goods.add(new WrapperBouquet("Wrapper", "craft paper", 5));
		goods.add(new WrapperBouquet("Wrapper", "transparent film", 3));
		goods.add(new Flowerpot("Flowerpot", "orchid", 300, PlantSize.SMALL, "plastic"));
		goods.add(new Flowerpot("Flowerpot", "dracaena", 250, PlantSize.BIG, "ceramics"));
		goods.add(new Flowerpot("Flowerpot", "palm pandanus", 150, PlantSize.SMALL, "ceramics"));
		goods.add(new Flowerpot("Flowerpot", "cactus", 150, PlantSize.BIG, "plastic"));
		return goods;
	}

	// The method can add new product to the collection of existing goods
	public void addTheProductToTheListOfGoods(Product newGoods) {
		products.add(newGoods);
	}

	// The method return collection of flowers for creating bouquets in shop
	private List<Flower> getSpecifiedNumberAndTypeOfFlower(int numberOfFlowers, Flower flower) {
		List<Flower> flowers = new ArrayList<Flower>();
		for (int i = 0; i < numberOfFlowers; i++) {
			flowers.add(flower);
		}
		return flowers;
	}

	// The method returns specified type of flowers and their amount for creating a
	// bouquet
	private List<Flower> getRoseMixBouquets() {
		List<Flower> flowers = new ArrayList<Flower>();
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(11, new Flower("Flower", "rose", 50, PlantSize.BIG, "red")));
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(11, new Flower("Flower", "rose", 50, PlantSize.BIG, "white")));
		flowers.addAll(
				getSpecifiedNumberAndTypeOfFlower(11, new Flower("Flower", "rose", 45, PlantSize.SMALL, "pink")));
		return flowers;
	}

	// The method returns specified type of flowers and their amount for creating a
	// bouquet
	private List<Flower> getChrysanthemumMixBouquet() {
		List<Flower> flowers = new ArrayList<Flower>();
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(9,
				new Flower("Flower", "chrysanthemum", 40, PlantSize.SMALL, "purple")));
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(9,
				new Flower("Flower", "chrysanthemum", 40, PlantSize.SMALL, "yellow")));
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(9,
				new Flower("Flower", "chrysanthemum", 45, PlantSize.BIG, "white")));
		flowers.addAll(getSpecifiedNumberAndTypeOfFlower(9,
				new Flower("Flower", "chrysanthemum", 45, PlantSize.BIG, "green")));
		flowers.addAll(
				getSpecifiedNumberAndTypeOfFlower(9, new Flower("Flower", "chrysanthemum", 45, PlantSize.BIG, "blue")));
		return flowers;
	}

	private Bouquet createRosesMixBouquet() {
		Bouquet roseMix = new Bouquet("Bouquet", getRoseMixBouquets(), new Tape("Tape", "decorative", 2, "blue"),
				new WrapperBouquet("Wrapper", "craft paper", 5));
		roseMix.setType("mix roses");
		return roseMix;
	}

	private Bouquet createChrysanthemumsMixBouquet() {
		Bouquet chrysanthemumsMix = new Bouquet("Bouquet", getChrysanthemumMixBouquet(),
				new Tape("Tape", "brilliant", 2, "purple"), new WrapperBouquet("Wrapper", "craft paper", 5));
		chrysanthemumsMix.setType("mix chrysanthemums");
		return chrysanthemumsMix;
	}

	// The method returns all names of goods which user can order
	public Set<String> getAllNamesOfGoods() {
		Set<String> nameOfGoods = new HashSet<String>();
		for (Product p : products) {
			nameOfGoods.add(p.getNameOfGoods());
		}
		nameOfGoods.add("Bouquet to order");
		return nameOfGoods;
	}

	public void addGoodsToTheShoppingBasket(Product product) {
		basket.add(product);
	}

	// The method calculates prices of goods which user put in the basket
	public int calculatingPricesBoughtGoods() {
		int price = 0;
		for (Product p : basket) {
			price += p.getPrice();
		}
		return price;
	}

	// The method asks user what kind of payment he wants to use
	public boolean payAFee(String paymentMethod) {
		switch (paymentMethod.toLowerCase()) {
			case "pay pal":
				return true;
			case "cash":
				return true;
			case "terminal":
				return true;
			default:
				return false;
		}
	}

	// The method asks user what kind of delivery he wants to use
	public boolean deliveryGoods(String deliver) {
		switch (deliver.toLowerCase()) {
			case "new post":
				return true;
			case "courier":
				return true;
			case "another type of delivery":
				return true;
			default:
				return false;
		}
	}

}