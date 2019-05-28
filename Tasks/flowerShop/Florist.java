package ua.flowerShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.flowerShop.materialForFloristry.*;
import ua.flowerShop.plant.*;

public class Florist {
	// The class receives the necessary instances of the store's collections object
	// in the class FlowerShop
	// and creates new flower objects for bouquets

	private FlowerShop shop = new FlowerShop();

	// The method creates predefined flowers, their amount and returns array of new
	// flowers
	public Flower[] createSpecifiedInstancesOfFlowers(int numberOfFlowers, Flower flower) {
		Flower[] flowers = new Flower[numberOfFlowers];
		for (int i = 0; i < numberOfFlowers; i++) {
			flowers[i] = flower;
		}
		return flowers;
	}

	// The method takes arrays of flowers and converts their into the only list
	// which will form a user's bouquet
	public List<Flower> convertListArraysOfFlowers(List<Flower[]> flower) {
		List<Flower> flowers = new ArrayList<Flower>();
		for (Flower[] f : flower) {
			flowers.addAll(Arrays.asList(f));
		}
		return flowers;
	}

	// The method asks user what type of flowers and their amount he wants in his
	// bouquet, if user inputs date incorrect a method throws exception
	public Flower[] getSpecifiedInstancesOfFlowers(String flower, int numberOfFlowers) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof Flower) {
				if (flower.equals(((Flower) p).getColor() + " " + p.getType())) {
					return createSpecifiedInstancesOfFlowers(numberOfFlowers, (Flower) p);
				}
			}
		}
		throw new EnteringDateException("You can choose only red/white/pink rose OR red/yellow/purple tulip "
				+ "OR purple/yellow/white chrysanthemum OR red/white peony. Sorry!");
	}

	// The following methods return necessary type of instance from collection all
	// the goods considering their fields, otherwise throw appropriate exception
	public Tape getSpecifiedTape(String color) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof Tape) {
				if (color.equals(((Tape) p).getColor())) {
					return (Tape) p;
				}
			}
		}
		throw new EnteringDateException("You can choose only (white/yellow/blue) tape's color. We're sorry!");
	}

	public WrapperBouquet getSpecifiedWrapper(String material) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof WrapperBouquet) {
				if (material.equals(p.getType())) {
					return (WrapperBouquet) p;
				}
			}
		}
		throw new EnteringDateException("You can choose only (craft paper/transparent film) wrapper. We're sorry!");
	}

	public Flower getSpecifiedFlower(String colorAndType) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof Flower) {
				if ((colorAndType.equals(((Flower) p).getColor() + " " + p.getType()))) {
					return (Flower) p;
				}
			}
		}
		throw new EnteringDateException("You can choose only red/white/pink rose OR red/yellow/purple tulip "
				+ "OR purple/yellow/white chrysanthemum OR red/white peony. Sorry!");
	}

	public Flowerpot getSpecifiedFlowerpot(String type) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof Flowerpot) {
				if (type.equals(p.getType())) {
					return (Flowerpot) p;
				}
			}
		}
		throw new EnteringDateException("You can choose only orchid OR dracaena OR palm Pandanus OR cactus. Sorry!");
	}

	public Bouquet getSpecifiedBouquet(String type) throws EnteringDateException {
		for (Product p : shop.products) {
			if (p instanceof Bouquet) {
				if (type.equals(p.getType())) {
					return (Bouquet) p;
				}
			}
		}
		throw new EnteringDateException("You can choose only mix roses and mix chrysanthemums. Sorry!");
	}
	
	public Tree getSpecifiedTree(String type) throws EnteringDateException {
		throw new EnteringDateException("Information is absent");
	}

}
