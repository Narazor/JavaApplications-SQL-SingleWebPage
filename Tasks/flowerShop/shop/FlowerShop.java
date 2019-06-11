package ua.flowerShop.shop;

import java.util.ArrayList;
import java.util.List;

import ua.flowerShop.enums.*;
import ua.flowerShop.product.*;
import ua.flowerShop.properties.*;

public class FlowerShop {

	public List<Product> getAllGoods() {
		List<Product> goods = new ArrayList<Product>();
		goods.add(new Flower("red rose", new PropertiesFlowersWithSpines(CountryEnum.NETHERLANDS, 20, Size.MEDIUM)));
		goods.add(new Flower("white rose", new PropertiesFlowersWithSpines(CountryEnum.UKRAINE, 45, Size.BIG)));
		goods.add(new Flower("red tulip", new PropertiesFlowersWithConstantForm(CountryEnum.NETHERLANDS, 35)));
		goods.add(new Flower("white tulip", new PropertiesFlowersWithConstantForm(CountryEnum.HOLLAND, 35)));
		goods.add(new Flower("yellow tulip", new PropertiesFlowersWithConstantForm(CountryEnum.HOLLAND, 35)));
		goods.add(new Flower("chamomile", new PropertiesFlowersWithConstantForm(CountryEnum.UKRAINE, 40)));
		goods.add(new Flower("white chrysanthemum", new PropertiesBushyFlowers(CountryEnum.COLOMBIA, 4)));
		goods.add(new Flower("yellow chrysanthemum", new PropertiesBushyFlowers(CountryEnum.UKRAINE, 3)));
		goods.add(new Flower("purple chrysanthemum", new PropertiesBushyFlowers(CountryEnum.NETHERLANDS, 5)));
		goods.add(new Flower("blue chrysanthemum", new PropertiesBushyFlowers(CountryEnum.UKRAINE, 5)));
		goods.add(new Bouquet("mix of roses", getMixOfRosesForBouquet()));
		goods.add(new Bouquet("mix of chrysanthemums", getMixOfChrysanthemumForBouquet()));
		goods.add(new Flowerpot("cactus", new Pot("ceramic", Size.BIG), 130));
		goods.add(new Flowerpot("ficus", new Pot("ceramic", Size.BIG), 160));
		goods.add(new Flowerpot("bamboo palm", new Pot("wooden", Size.BIG), 200));
		goods.add(new Ribbon("white ribbon", "brilliant"));
		goods.add(new Ribbon("blue ribbon", "matt"));
		goods.add(new Paper("craft paper"));
		goods.add(new Paper("transparent film"));
		return goods;
	}

	// The method creates predefined flowers, their amount and returns list of these
	// flowers
	public List<Flower> getFlowersForBouquet(int numberOfFlowers, Flower typeOfFlower) {
		List<Flower> flowerForBouquet = new ArrayList<Flower>();
		for (int i = 0; i < numberOfFlowers; i++) {
			flowerForBouquet.add(typeOfFlower);
		}
		return flowerForBouquet;
	}

	// The method creates mix roses for the bouquet
	public List<Flower> getMixOfRosesForBouquet() {
		List<Flower> roses = new ArrayList<Flower>();
		roses.addAll(getFlowersForBouquet(9,
				new Flower("Red rose", new PropertiesFlowersWithSpines(CountryEnum.NETHERLANDS, 60, Size.BIG))));
		roses.addAll(getFlowersForBouquet(9,
				new Flower("White rose", new PropertiesFlowersWithSpines(CountryEnum.NETHERLANDS, 60, Size.BIG))));
		roses.addAll(getFlowersForBouquet(9,
				new Flower("Blue rose", new PropertiesFlowersWithSpines(CountryEnum.NETHERLANDS, 60, Size.BIG))));
		return roses;
	}

	// The method creates mix chrysanthemums for the bouquet
	public List<Flower> getMixOfChrysanthemumForBouquet() {
		List<Flower> chrysanthemum = new ArrayList<Flower>();
		chrysanthemum.addAll(getFlowersForBouquet(11,
				new Flower("White chrysanthemum", new PropertiesBushyFlowers(CountryEnum.COLOMBIA, 3))));
		chrysanthemum.addAll(getFlowersForBouquet(11,
				new Flower("Yellow chrysanthemum", new PropertiesBushyFlowers(CountryEnum.UKRAINE, 4))));
		chrysanthemum.addAll(getFlowersForBouquet(11,
				new Flower("Purple chrysanthemum", new PropertiesBushyFlowers(CountryEnum.UKRAINE, 7))));
		return chrysanthemum;
	}

	// The method returns all names of goods, which belong to the specified class
	public List<String> getSpecifiedDescriptionOfGoods(String userChoice) {
		List<String> specifiedGoods = new ArrayList<String>();
		for (Product product : getAllGoods()) {
			switch (userChoice) {
			case "1":
			case "6":
				if (product instanceof Flower) {
					specifiedGoods.add(product.getDescription());
				}
				break;
			case "2":
				if (product instanceof Flowerpot) {
					specifiedGoods.add(product.getDescription());
				}
				break;
			case "3":
				if (product instanceof Paper) {
					specifiedGoods.add(product.getDescription());
				}
				break;
			case "4":
				if (product instanceof Ribbon) {
					specifiedGoods.add(product.getDescription());
				}
				break;
			case "5":
				if (product instanceof Bouquet) {
					specifiedGoods.add(product.getDescription());
				}
				break;

			}
		}
		return specifiedGoods;
	}

}